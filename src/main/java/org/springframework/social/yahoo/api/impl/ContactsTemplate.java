package org.springframework.social.yahoo.api.impl;

import org.springframework.social.yahoo.api.ContactsOperations;
import org.springframework.social.yahoo.module.Field;
import org.springframework.social.yahoo.module.FieldType;
import org.springframework.social.yahoo.module.YahooContact;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class ContactsTemplate extends AbstractYahooOperations implements ContactsOperations {

    private RestTemplate restTemplate;

    public ContactsTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(isAuthorized);
        this.restTemplate = restTemplate;
    }

    @Override
    public Set<Field> getFieldsForContact(YahooContact yahooContact, Set<FieldType> fieldTypes) {
        return null;
    }
}
