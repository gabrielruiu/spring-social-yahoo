package org.springframework.social.yahoo.api.impl;

import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.util.Arrays;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
//TODO: isAppAuthorized, need to implement?
abstract class AbstractYahooOperations {

    private static final String API_URL_BASE = "https://social.yahooapis.com/v1/user/%s";
    private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();

    private boolean isAuthorized;
    private String guid;

    public AbstractYahooOperations(boolean isAuthorized, String guid) {
        this.isAuthorized = isAuthorized;
        this.guid = guid;
    }

    protected String getApiUrlBase() {
        return API_URL_BASE;
    }

    protected URI buildUri(String path) {
        return buildUri(path, EMPTY_PARAMETERS);
    }

    protected URI buildUri(String path, String parameterName, String parameterValue) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set(parameterName, parameterValue);
        return buildUri(path, parameters);
    }

    protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
        parameters.put("format", Arrays.asList("json"));
        return URIBuilder.fromUri(String.format(getApiUrlBase() + path, guid)).queryParams(parameters).build();
    }
}
