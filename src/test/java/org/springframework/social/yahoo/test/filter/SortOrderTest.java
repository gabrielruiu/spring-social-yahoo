package org.springframework.social.yahoo.test.filter;

import org.junit.Test;
import org.springframework.social.yahoo.filter.SortOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
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
