/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.gabrielruiu.springsocial.yahoo.connect;

import com.github.gabrielruiu.springsocial.yahoo.api.Yahoo;
import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.oauth1.OAuthToken;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class YahooConnectionFactory extends OAuth1ConnectionFactory<Yahoo> {

    public YahooConnectionFactory(String consumerKey, String consumerSecret) {
        super("yahoo", new YahooServiceProvider(consumerKey, consumerSecret) , new YahooAdapter());
    }

    @Override
    protected String extractProviderUserId(OAuthToken accessToken) {
        YahooOAuthToken token = (YahooOAuthToken) accessToken;
        return token.getGuid();
    }
}
