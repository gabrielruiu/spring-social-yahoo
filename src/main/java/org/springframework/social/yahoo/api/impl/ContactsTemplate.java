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

package org.springframework.social.yahoo.api.impl;

import org.springframework.social.yahoo.api.ContactsOperations;
import org.springframework.social.yahoo.module.*;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class ContactsTemplate extends AbstractYahooOperations implements ContactsOperations {

    private RestTemplate restTemplate;
    private String guid;

    public ContactsTemplate(RestTemplate restTemplate, boolean isAuthorized, String guid) {
        super(isAuthorized);
        this.restTemplate = restTemplate;
        this.guid = guid;
    }

    public Set<Field> getFieldsForContact(Contact contact, Set<FieldType> fieldTypes) {
        return null;
    }

    public Contacts getContacts() {
        return restTemplate.getForObject(buildUri(String.format("/user/%s/contacts", guid)), ContactsWrapper.class).getContacts();
    }
}
