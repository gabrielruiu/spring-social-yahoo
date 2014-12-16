package org.springframework.social.yahoo.test.filter;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.social.yahoo.filter.RequestCustomizer;
import org.springframework.social.yahoo.filter.SortFields;
import org.springframework.social.yahoo.filter.SortFields.SortableField;
import org.springframework.social.yahoo.module.FieldType;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.social.yahoo.filter.SortFields.SortableField.DISPLAY_NAME;
import static org.springframework.social.yahoo.module.FieldType.ADDRESS;
import static org.springframework.social.yahoo.module.FieldType.ANNIVERSARY;
import static org.springframework.social.yahoo.module.FieldType.EMAIL;
import static org.springframework.social.yahoo.module.FieldType.GUID;
import static org.springframework.social.yahoo.module.FieldType.NAME;
import static org.springframework.social.yahoo.module.FieldType.YAHOOID;


/**
 * Test class that verifies if the {@link SortFields} implementation of the {@link RequestCustomizer} properly builds
 * requests for sorting by certain fields, and that only valid fields can be used to construct the request, as outlined
 * in the Yahoo documentation for sorting
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/sorting.html">Sorting</a>
 * @see {@link SortFields}
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
@RunWith(JUnitParamsRunner.class)
public class SortFieldsTest {

    private static final String VALID_REQUEST_SEVERAL_SORT_FIELDS = "sort-fields=email,guid,yahooid,displayName";
    private static final String VALID_REQUEST_SINGLE_SORT_FIELDS = "sort-fields=anniversary";

    @Test
    public void shouldReturnEmptyStringForNoSortingFields() {
        SortFields sortFields = new SortFields();

        assertThat(sortFields.toRequest(), is(""));
    }

    @Test
    public void shouldConstructValidRequestForSingleSortField() {
        SortFields sortFields = new SortFields();
        sortFields.addFields(ANNIVERSARY);

        assertThat(sortFields.toRequest(), is(VALID_REQUEST_SINGLE_SORT_FIELDS));
    }

    @Test
    public void shouldConstructValidRequestForSeveralSortingFields() {
        SortFields sortFields = new SortFields();
        sortFields.addFields(EMAIL, GUID, YAHOOID);
        sortFields.addFields(DISPLAY_NAME);

        assertThat(sortFields.toRequest(), is(VALID_REQUEST_SEVERAL_SORT_FIELDS));
    }

    @Test
    @Parameters(method = "validFieldTypes")
    public void shouldAllowAddingValidFieldTypes(FieldType validFieldType) {
        SortFields sortFields = new SortFields();

        assertThat(sortFields.isFieldAllowed(validFieldType.name().toLowerCase()), is(true));
    }

    @Test
    @Parameters(method = "validSortableFields")
    public void shouldAllowAddingSortableFields(SortableField sortableField) {
        SortFields sortFields = new SortFields();

        assertThat(sortFields.isFieldAllowed(sortableField.getParameterName()), is(true));
    }

    @Test
    @Parameters(method = "invalidFields")
    public void shouldPreventAddingInvalidFields(String invalidField) {
        SortFields sortFields = new SortFields();

        assertThat(sortFields.isFieldAllowed(invalidField), is(false));
    }

    /**
     * All {@link FieldType}s are valid for sorting, except for NAME and ADDRESS.
     * Requests can be sorted by names using the enum values of {@link SortableField}.
     */
    private Object[] validFieldTypes() {

        Collection<FieldType> fieldTypes = Collections2.filter(Arrays.asList(FieldType.values()), new Predicate<FieldType>() {
            @Override
            public boolean apply(FieldType input) {
                return !(input.equals(NAME) || input.equals(ADDRESS));
            }
        });
        return fieldTypes.toArray(new Object[]{});
    }

    /**
     * All {@link SortableField} are valid for sorting.
     */
    private Object[] validSortableFields() {
        return SortableField.values();
    }

    private Object[] invalidFields() {
        return new Object[]{"invalidField1", "invalidField2", "invalidField3", ADDRESS.name().toLowerCase(),
                            NAME.name().toLowerCase()};
    }
}
