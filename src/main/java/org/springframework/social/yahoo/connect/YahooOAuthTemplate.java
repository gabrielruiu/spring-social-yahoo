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
package org.springframework.social.yahoo.connect;

import org.springframework.social.oauth1.OAuth1Template;
import org.springframework.social.oauth1.OAuth1Version;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.util.MultiValueMap;

/**
 * Custom implementation of {@link OAuth1Template} that picks the extra headers from Yahoo during the
 * OAuth flow, the most important of which is the users GUID.
 *
 * The GUID is mandatory for constructing subsequent calls/requests to the Yahoo API.
 *
 * @see <a href="https://developer.yahoo.com/oauth/guide/oauth-auth-flow.html">OAuth flow</a>
 * @see <a href="https://developer.yahoo.com/oauth/guide/oauth-accesstoken.html">OAuth access token</a>
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/introspective-guid-resource.html">GUID</a>
 * @see {@link org.springframework.social.yahoo.api.impl.AbstractYahooOperations}
 *
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class YahooOAuthTemplate extends OAuth1Template {

    public static final String OAUTH_RESPONSE_GUID_KEY = "xoauth_yahoo_guid";
    public static final String OAUTH_EXPIRES_IN = "oauth_expires_in";
    public static final String OAUTH_SESSION_HANDLE = "oauth_session_handle";
    public static final String OAUTH_AUTHORIZATION_EXPIRES_IN = "oauth_authorization_expires_in";

    private YahooOAuthToken oAuthToken;

    public YahooOAuthTemplate(String consumerKey, String consumerSecret, String requestTokenUrl, String authorizeUrl, String accessTokenUrl) {
        super(consumerKey, consumerSecret, requestTokenUrl, authorizeUrl, accessTokenUrl);
    }

    public YahooOAuthTemplate(String consumerKey, String consumerSecret, String requestTokenUrl, String authorizeUrl, String accessTokenUrl, OAuth1Version version) {
        super(consumerKey, consumerSecret, requestTokenUrl, authorizeUrl, accessTokenUrl, version);
    }

    public YahooOAuthTemplate(String consumerKey, String consumerSecret, String requestTokenUrl, String authorizeUrl, String authenticateUrl, String accessTokenUrl) {
        super(consumerKey, consumerSecret, requestTokenUrl, authorizeUrl, authenticateUrl, accessTokenUrl);
    }

    public YahooOAuthTemplate(String consumerKey, String consumerSecret, String requestTokenUrl, String authorizeUrl, String authenticateUrl, String accessTokenUrl, OAuth1Version version) {
        super(consumerKey, consumerSecret, requestTokenUrl, authorizeUrl, authenticateUrl, accessTokenUrl, version);
    }

    @Override
    protected OAuthToken createOAuthToken(String tokenValue, String tokenSecret, MultiValueMap<String, String> response) {
        YahooOAuthToken oAuthToken = new YahooOAuthToken(tokenValue, tokenSecret);
        if (response.getFirst(OAUTH_AUTHORIZATION_EXPIRES_IN) != null) {
            oAuthToken.setAuthorizationExpiresIn(Long.valueOf(response.getFirst(OAUTH_AUTHORIZATION_EXPIRES_IN)));
        }
        if (response.getFirst(OAUTH_EXPIRES_IN) != null) {
            oAuthToken.setExpiresIn(Long.valueOf(response.getFirst(OAUTH_EXPIRES_IN)));
        }
        oAuthToken.setSessionHandle(response.getFirst(OAUTH_SESSION_HANDLE));
        oAuthToken.setGuid(response.getFirst(OAUTH_RESPONSE_GUID_KEY));
        this.oAuthToken = oAuthToken;
        return this.oAuthToken;
    }

    public YahooOAuthToken getoAuthToken() {
        return oAuthToken;
    }
}
