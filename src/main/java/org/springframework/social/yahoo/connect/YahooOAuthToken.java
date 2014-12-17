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

import org.springframework.social.oauth1.OAuthToken;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class YahooOAuthToken extends OAuthToken {

    //TODO: create GUID object and link it to this field
    private String guid;
    /**
     * Lifetime of the Access Token in seconds (3600, or 1 hour).
     */
    private Long expiresIn;

    /**
     * The persistent credential used by Yahoo to identify the Consumer after a User has
     * authorized access to private data. Include this credential in your request to refresh
     * the Access Token once it expires.
     */
    private String sessionHandle;

    /**
     * Lifetime of the oauth_session_handle in seconds.
     */
    private Long authorizationExpiresIn;

    public YahooOAuthToken(String value, String secret) {
        super(value, secret);
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getSessionHandle() {
        return sessionHandle;
    }

    public void setSessionHandle(String sessionHandle) {
        this.sessionHandle = sessionHandle;
    }

    public Long getAuthorizationExpiresIn() {
        return authorizationExpiresIn;
    }

    public void setAuthorizationExpiresIn(Long authorizationExpiresIn) {
        this.authorizationExpiresIn = authorizationExpiresIn;
    }
}
