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
import com.github.gabrielruiu.springsocial.yahoo.filter.SearchFilter;
import com.github.gabrielruiu.springsocial.yahoo.filter.SearchFilter.SearchableField;
import com.github.gabrielruiu.springsocial.yahoo.module.FieldType;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static com.github.gabrielruiu.springsocial.yahoo.filter.SearchFilter.SearchFilterConstraint.*;
import static com.github.gabrielruiu.springsocial.yahoo.filter.SearchFilter.SearchableField.CATEGORY;
import static com.github.gabrielruiu.springsocial.yahoo.filter.TokenUtils.SYMBOL_COMMA;
import static com.github.gabrielruiu.springsocial.yahoo.filter.TokenUtils.SYMBOL_SEMICOLON;
import static com.github.gabrielruiu.springsocial.yahoo.module.FieldType.EMAIL;
import static com.github.gabrielruiu.springsocial.yahoo.module.FieldType.NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test class that verifies if the {@link SearchFilter} implementation of {@link ContactsRequestCustomizer} properly
 * builds requests for filtering the Contacts resource and that only valid fields can be used to construct the
 * request, as outlined in the Yahoo documentation for search filtering
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/contacts_resource-filters.html">Filtering</a>
 * @see {@link SearchFilter}
 *
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
@RunWith(JUnitParamsRunner.class)
public class SearchFilterTest {

    private static final String VALID_OR_SEARCH_FILTER = "email.present=1,email.is=my_email@email.com";
    private static final String VALID_AND_SEARCH_FILTER = "email.cs-contains=yahoo.com;category.is=group1";
    private static final String MY_EMAIL = "my_email@email.com";
    private static final String GROUP1_CATEGORY = "group1";

    @Test
    public void shouldReturnEmptyStringForNoDisplayFilters() {
        SearchFilter searchFilter = new SearchFilter();

        assertThat(searchFilter.toRequest(), is(""));
    }

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
