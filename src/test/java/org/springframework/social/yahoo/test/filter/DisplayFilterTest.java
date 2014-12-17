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
package org.springframework.social.yahoo.test.filter;

import org.junit.Test;
import org.springframework.social.yahoo.filter.ContactsRequestCustomizer;
import org.springframework.social.yahoo.filter.DisplayFilter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.social.yahoo.module.FieldType.NICKNAME;
import static org.springframework.social.yahoo.module.FieldType.YAHOOID;


/**
 * Test class that verifies if the {@link DisplayFilter} implementation of {@link ContactsRequestCustomizer} properly
 * builds requests for filtering the fields in each Contact of the Contacts resource,
 * as outlined in the Yahoo documentation for display filtering
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/contacts_resource-filters.html">Filtering</a>
 * @see {@link DisplayFilter}
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class DisplayFilterTest {

    private static final String VALID_DISPLAY_FILTER = "out=yahooid,nickname";

    @Test
    public void shouldReturnEmptyStringForNoDisplayFilters() {
        DisplayFilter displayFilter = new DisplayFilter();

        assertThat(displayFilter.toRequest(), is(""));
    }

    @Test
    public void shouldConstructValidDisplayFilter() {
        DisplayFilter displayFilter = new DisplayFilter();
        displayFilter.addFields(YAHOOID, NICKNAME);

        assertThat(displayFilter.toRequest(), is(VALID_DISPLAY_FILTER));
    }
}
