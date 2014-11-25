package org.springframework.social.yahoo.test.response;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.social.yahoo.response.YahooStatusCode;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.is;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class TestYahooStatusCode {

    @Test
    public void shouldReturnStatusCodesForNonErrorResponses() {
        List<YahooStatusCode> statusCodes = YahooStatusCode.successStatuses();

        assertThat(statusCodes, everyItem(Matchers.<YahooStatusCode>hasProperty("error", is(Boolean.FALSE))));
    }

    @Test
    public void shouldReturnStatusCodesForErrorResponses() {
        List<YahooStatusCode> statusCodes = YahooStatusCode.errorStatuses();

        assertThat(statusCodes, everyItem(Matchers.<YahooStatusCode>hasProperty("error", is(Boolean.TRUE))));
    }
}
