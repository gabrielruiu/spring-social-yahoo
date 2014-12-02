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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.yahoo.api.ContactsOperations;
import org.springframework.social.yahoo.api.SocialDirectoryOperations;
import org.springframework.social.yahoo.api.Yahoo;
import org.springframework.social.yahoo.module.YahooModule;
import org.springframework.web.client.RestTemplate;

/**
 * //TODO: in documentation for this class, mention the YDN help site for Yahoo Social API (https://developer.yahoo.com/social/rest_api_guide/)
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class YahooTemplate extends AbstractOAuth1ApiBinding implements Yahoo {

    private String guid;
    private ContactsOperations contactsOperations;
    private SocialDirectoryOperations socialDirectoryOperations;

    public YahooTemplate(String consumerKey, String consumerSecret,
                         String accessToken, String accessTokenSecret, String guid) {
        super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        this.guid = guid;
        initSubApis();
    }

    public ContactsOperations contactsOperations() {
        return contactsOperations;
    }

    public SocialDirectoryOperations socialDirectoryOperations() {
        return socialDirectoryOperations;
    }

    @Override
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
        MappingJackson2HttpMessageConverter converter = super.getJsonMessageConverter();
        converter.setObjectMapper(createObjectMapper());
        return converter;
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new YahooErrorHandler());
    }

    protected void initSubApis() {
        this.contactsOperations = new ContactsTemplate(getRestTemplate(), isAuthorized(), guid);
        this.socialDirectoryOperations = new SocialDirectoryTemplate(getRestTemplate(), isAuthorized());
    }

    protected ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new YahooModule());
        return mapper;
    }
}
