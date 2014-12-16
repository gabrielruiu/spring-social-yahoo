package org.springframework.social.yahoo.test.filter;

import org.junit.Test;
import org.springframework.social.yahoo.filter.SearchFilter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.social.yahoo.filter.SearchFilter.SearchFilterKey.IS;
import static org.springframework.social.yahoo.filter.SearchFilter.SearchFilterKey.PRESENT;
import static org.springframework.social.yahoo.filter.TokenConstants.SYMBOL_COMMA;
import static org.springframework.social.yahoo.module.FieldType.EMAIL;

/**
 * Test class which verifies that the 'or' variant of {@link SearchFilter} builds
 * correct search requests, using comma symbols between search tokens.
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/contacts_resource-filters.html">Filtering</a>
 * @see SearchFilter
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class OrSearchFilterTest {

    private static final String VALID_OR_SEARCH_FILTER = "email.present=1,email.is=my_email@email.com";
    private static final String SOME_EMAIL = "my_email@email.com";

    @Test
    public void shouldConstructValidOrSearchRequest() {
        SearchFilter orSearchFilter = new SearchFilter(SYMBOL_COMMA);
        orSearchFilter.addField(EMAIL, PRESENT, "1");
        orSearchFilter.addField(EMAIL, IS, SOME_EMAIL);

        assertThat(orSearchFilter.toRequest(), is(VALID_OR_SEARCH_FILTER));
    }
}
