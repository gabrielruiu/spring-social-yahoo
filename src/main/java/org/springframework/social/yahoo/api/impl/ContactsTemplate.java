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
import org.springframework.social.yahoo.filter.ContactsFilter;
import org.springframework.social.yahoo.module.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class ContactsTemplate extends AbstractYahooOperations implements ContactsOperations {

    private RestTemplate restTemplate;

    public ContactsTemplate(RestTemplate restTemplate, boolean isAuthorized, String guid) {
        super(isAuthorized, guid);
        this.restTemplate = restTemplate;
    }

    public Contacts getContacts() {
        return restTemplate.getForObject(buildUri("/contacts"), ContactsWrapper.class).getContacts();
    }

    @Override
    public Contacts getContacts(ContactsFilter filter) {
        return restTemplate.getForObject(buildUri(String.format("/contacts;%s", filter.build())), ContactsWrapper.class).getContacts();
    }

    public Contacts getContactsByCategory(String categoryName) {
        return restTemplate.getForObject(buildUri(String.format("/category/%s/contacts", categoryName)), ContactsWrapper.class).getContacts();
    }

    public Contact getContact(int contactCid) {
        return restTemplate.getForObject(buildUri(String.format("/contact/%d", contactCid)), ContactWrapper.class).getContact();
    }

    public void addCategory(Category category) {
        restTemplate.postForObject(buildUri("/categories"), category, Void.class);
    }

    public List<Category> getCategories() {
        return restTemplate.getForObject(buildUri("/categories"), CategoriesWrapper.class).getCategories().getCategory();
    }

    public List<Category> getCategoriesByContactCid(int contactCid) {
        return restTemplate.getForObject(buildUri(String.format("/contact/%d/categories", contactCid)), CategoriesWrapper.class).getCategories().getCategory();
    }
}
