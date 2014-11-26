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

package org.springframework.social.yahoo.response;

import java.util.Locale;

/**
 * Base class that defines the common fields that every Yahoo response has,
 * regardless of the nature of the response
 *
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public abstract class AbstractResponse {

    /**
     * The status code of the received response, which maps the HTTP status
     * code with a flag that determines if the response is an error or not.
     */
    private YahooStatusCode statusCode;

    /**
     * The reference to the actual resource.
     * The value of this attribute is the same as that of the Content-Location header.
     */
    private String uri;

    /**
     * The language of the representation. Examples: de-DE, de-AT, de-BE. The value of this attribute is the
     * same as that of the Content-Language header. The value is an RFC 4646 language tag.
     */
    private Locale lang;

    public YahooStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(YahooStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Locale getLang() {
        return lang;
    }

    public void setLang(Locale lang) {
        this.lang = lang;
    }
}
