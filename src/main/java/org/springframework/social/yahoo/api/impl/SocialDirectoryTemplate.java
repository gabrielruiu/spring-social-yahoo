package org.springframework.social.yahoo.api.impl;

import org.springframework.social.yahoo.api.SocialDirectoryOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class SocialDirectoryTemplate extends AbstractYahooOperations implements SocialDirectoryOperations {

    private RestTemplate restTemplate;

    public SocialDirectoryTemplate(RestTemplate restTemplate, boolean isAuthorized, String guid) {
        super(isAuthorized, guid);
        this.restTemplate = restTemplate;
    }
}
