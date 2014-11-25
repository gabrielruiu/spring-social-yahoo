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
