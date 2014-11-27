package org.springframework.social.yahoo.api.impl;

import org.springframework.social.yahoo.api.ContactsOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class ContactsTemplate extends AbstractYahooOperations implements ContactsOperations {

    private RestTemplate restTemplate;

    public ContactsTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(isAuthorized);
        this.restTemplate = restTemplate;
    }
}
