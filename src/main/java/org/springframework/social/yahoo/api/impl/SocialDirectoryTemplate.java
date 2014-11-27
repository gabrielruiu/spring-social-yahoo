package org.springframework.social.yahoo.api.impl;

import org.springframework.social.yahoo.api.SocialDirectoryOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class SocialDirectoryTemplate extends AbstractYahooOperations implements SocialDirectoryOperations {

    private RestTemplate restTemplate;

    public SocialDirectoryTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(isAuthorized);
        this.restTemplate = restTemplate;
    }
}
