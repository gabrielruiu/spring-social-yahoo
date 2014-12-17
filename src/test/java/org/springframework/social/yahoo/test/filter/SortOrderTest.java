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
import org.springframework.social.yahoo.filter.SortOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * Test class that verifies if the {@link SortOrder} implementation of the {@link ContactsRequestCustomizer} properly
 * builds requests for setting the sorting order.
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/sorting.html">Sorting</a>
 * @see {@link SortOrder}
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class SortOrderTest {

    private static final String VALID_REQUEST_SORT_ORDER_ASC = "sort=asc";
    private static final String VALID_REQUEST_SORT_ORDER_DESC = "sort=desc";
    private static final String INVALID_SORT_ORDER_FIELD = "email";

    @Test
    public void shouldConsiderOnlyOrderFieldsAsValid() {
        SortOrder sortOrder = new SortOrder();

        assertThat(sortOrder.isFieldAllowed(SortOrder.Order.ASC.name().toLowerCase()), is(true));
        assertThat(sortOrder.isFieldAllowed(SortOrder.Order.DESC.name().toLowerCase()), is(true));
        assertThat(sortOrder.isFieldAllowed(INVALID_SORT_ORDER_FIELD), is(false));
    }

    @Test
    public void shouldNotAllowAddingMoreThanOneToken() {
        SortOrder sortOrder = new SortOrder();
        sortOrder.setOrder(SortOrder.Order.DESC);
        sortOrder.setOrder(SortOrder.Order.DESC);
        sortOrder.setOrder(SortOrder.Order.ASC);
        sortOrder.setOrder(SortOrder.Order.ASC);

        assertThat(sortOrder.getTokens(), hasSize(1));
    }

    @Test
    public void shouldReturnEmptyStringForNoOrderSpecified() {
        SortOrder sortOrder = new SortOrder();

        assertThat(sortOrder.toRequest(), is(""));
    }

    @Test
    public void shouldConstructValidRequestForSortingAscending() {
        SortOrder sortOrder = new SortOrder();
        sortOrder.setOrder(SortOrder.Order.ASC);

        assertThat(sortOrder.toRequest(), is(VALID_REQUEST_SORT_ORDER_ASC));
    }

    @Test
    public void shouldConstructValidRequestForSortingDescending() {
        SortOrder sortOrder = new SortOrder();
        sortOrder.setOrder(SortOrder.Order.DESC);

        assertThat(sortOrder.toRequest(), is(VALID_REQUEST_SORT_ORDER_DESC));
    }
}
