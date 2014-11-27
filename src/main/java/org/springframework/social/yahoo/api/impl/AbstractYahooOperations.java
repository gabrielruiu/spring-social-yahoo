package org.springframework.social.yahoo.api.impl;

import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
//TODO: isAppAuthorized, need to implement?
abstract class AbstractYahooOperations {

    private boolean isAuthorized;

    public AbstractYahooOperations(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
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
        return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
    }

    private static final String API_URL_BASE = "https://social.yahooapis.com/v1/";

    private static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();
}
