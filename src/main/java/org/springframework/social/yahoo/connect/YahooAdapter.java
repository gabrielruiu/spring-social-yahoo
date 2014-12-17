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

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.yahoo.api.Yahoo;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
//TODO: implement YahooAdapter
public class YahooAdapter implements ApiAdapter<Yahoo> {

    public boolean test(Yahoo api) {
        return false;
    }

    public void setConnectionValues(Yahoo api, ConnectionValues values) {

    }

    public UserProfile fetchUserProfile(Yahoo api) {
        return null;
    }

    public void updateStatus(Yahoo api, String message) {

    }
}
