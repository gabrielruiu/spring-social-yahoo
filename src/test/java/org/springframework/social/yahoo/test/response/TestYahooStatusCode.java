/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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
