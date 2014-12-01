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

package org.springframework.social.yahoo.connect;

import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.yahoo.api.Yahoo;
import org.springframework.social.yahoo.api.impl.YahooTemplate;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class YahooServiceProvider extends AbstractOAuth1ServiceProvider<Yahoo> {

    //TODO: the response when querying for the quthentication token contains the guid of the currently logged in user, how to persist it for later use?
    public YahooServiceProvider(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret, new YahooOAuthTemplate(consumerKey, consumerSecret,
                "https://api.login.yahoo.com/oauth/v2/get_request_token",
                "https://api.login.yahoo.com/oauth/v2/request_auth",
                "https://api.login.yahoo.com/oauth/v2/get_token"
        ));
    }

    @Override
    public Yahoo getApi(String accessToken, String secret) {
        String guid = ((YahooOAuthTemplate)getOAuthOperations()).getoAuthToken().getGuid();
        return new YahooTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret, guid);
    }
}
