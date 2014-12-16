package org.springframework.social.yahoo.test.filter;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.social.yahoo.filter.RequestCustomizer;
import org.springframework.social.yahoo.filter.SearchFilter;
import org.springframework.social.yahoo.filter.SearchFilter.SearchableField;
import org.springframework.social.yahoo.module.FieldType;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.social.yahoo.filter.SearchFilter.SearchFilterKey.CS_CONTAINS;
import static org.springframework.social.yahoo.filter.SearchFilter.SearchFilterKey.IS;
import static org.springframework.social.yahoo.filter.SearchFilter.SearchFilterKey.PRESENT;
import static org.springframework.social.yahoo.filter.SearchFilter.SearchableField.CATEGORY;
import static org.springframework.social.yahoo.filter.TokenConstants.SYMBOL_COMMA;
import static org.springframework.social.yahoo.filter.TokenConstants.SYMBOL_SEMICOLON;
import static org.springframework.social.yahoo.module.FieldType.EMAIL;
import static org.springframework.social.yahoo.module.FieldType.NAME;

/**
 * Test class that verifies if the {@link SearchFilter} implementation of {@link RequestCustomizer} properly builds
 * requests for filtering the Contacts resource and that only valid fields can be used to construct the
 * request, as outlined in the Yahoo documentation for search filtering
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/contacts_resource-filters.html">Filtering</a>
 * @see {@link SearchFilter}
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
@RunWith(JUnitParamsRunner.class)
public class SearchFilterTest {

    private static final String VALID_OR_SEARCH_FILTER = "email.present=1,email.is=my_email@email.com";
    private static final String VALID_AND_SEARCH_FILTER = "email.cs-contains=yahoo.com;category.is=group1";
    private static final String MY_EMAIL = "my_email@email.com";
    private static final String GROUP1_CATEGORY = "group1";

    @Test
    public void shouldConstructValidOrSearchRequest() {
        SearchFilter orSearchFilter = new SearchFilter(SYMBOL_COMMA);
        orSearchFilter.addField(EMAIL, PRESENT, "1");
        orSearchFilter.addField(EMAIL, IS, MY_EMAIL);

        assertThat(orSearchFilter.toRequest(), is(VALID_OR_SEARCH_FILTER));
    }

    @Test
    public void shouldConstructValidAndSearchRequest() {
        SearchFilter andSearchFilter = new SearchFilter(SYMBOL_SEMICOLON);
        andSearchFilter.addField(EMAIL, CS_CONTAINS, "yahoo.com");
        andSearchFilter.addField(CATEGORY, IS, GROUP1_CATEGORY);

        assertThat(andSearchFilter.toRequest(), is(VALID_AND_SEARCH_FILTER));
    }

    @Test
    @Parameters(method = "validFieldTypes")
    public void shouldAllowAddingValidFieldTypes(FieldType fieldType) {
        SearchFilter searchFilter = new SearchFilter();

        assertThat(searchFilter.isFieldAllowed(fieldType.name().toLowerCase()), is(true));
    }

    @Test
    @Parameters(method = "validSearchableFields")
    public void shouldAllowAddingSearchableFields(SearchableField searchableField) {
        SearchFilter searchFilter = new SearchFilter();

        assertThat(searchFilter.isFieldAllowed(searchableField.getParameterName()), is(true));
    }

    @Test
    @Parameters(method = "invalidFields")
    public void shouldPreventAddingInvalidFields(String invalidField) {
        SearchFilter searchFilter = new SearchFilter();

        assertThat(searchFilter.isFieldAllowed(invalidField), is(false));
    }

    /**
     * All {@link FieldType}s are valid for search filtering, except FieldType.NAME
     */
    private Object[] validFieldTypes() {
        Collection<FieldType> fieldTypes = Collections2.filter(Arrays.asList(FieldType.values()), new Predicate<FieldType>() {
            @Override
            public boolean apply(FieldType input) {
                return !input.equals(NAME);
            }
        });
        return fieldTypes.toArray(new Object[]{});
    }

    /**
     * All {@link SearchableField}s are valid for search filtering
     */
    private Object[] validSearchableFields() {
        return SearchableField.values();
    }

    private Object[] invalidFields() {
        return new Object[]{"invalidField1", "invalidField2", "invalidField3", NAME.name().toLowerCase()};
    }
}
