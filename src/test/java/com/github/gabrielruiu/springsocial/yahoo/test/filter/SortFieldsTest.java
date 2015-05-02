/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.gabrielruiu.springsocial.yahoo.test.filter;

import com.github.gabrielruiu.springsocial.yahoo.filter.ContactsRequestCustomizer;
import com.github.gabrielruiu.springsocial.yahoo.filter.SortFields;
import com.github.gabrielruiu.springsocial.yahoo.filter.SortFields.SortableField;
import com.github.gabrielruiu.springsocial.yahoo.module.FieldType;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static com.github.gabrielruiu.springsocial.yahoo.filter.SortFields.SortableField.DISPLAY_NAME;
import static com.github.gabrielruiu.springsocial.yahoo.module.FieldType.ADDRESS;
import static com.github.gabrielruiu.springsocial.yahoo.module.FieldType.ANNIVERSARY;
import static com.github.gabrielruiu.springsocial.yahoo.module.FieldType.EMAIL;
import static com.github.gabrielruiu.springsocial.yahoo.module.FieldType.GUID;
import static com.github.gabrielruiu.springsocial.yahoo.module.FieldType.NAME;
import static com.github.gabrielruiu.springsocial.yahoo.module.FieldType.YAHOOID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Test class that verifies if the {@link SortFields} implementation of the {@link ContactsRequestCustomizer} properly
 * builds requests for sorting by certain fields, and that only valid fields can be used to construct the request, as outlined
 * in the Yahoo documentation for sorting
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/sorting.html">Sorting</a>
 * @see {@link SortFields}
 *
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
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
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
    private Object[] validSortableFields() {
        return SortableField.values();
    }

    @SuppressWarnings("unused")
    private Object[] invalidFields() {
        return new Object[]{"invalidField1", "invalidField2", "invalidField3", ADDRESS.name().toLowerCase(),
                            NAME.name().toLowerCase()};
    }
}
