package org.springframework.social.yahoo.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.yahoo.api.Yahoo;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
//TODO: implement YahooAdapter
public class YahooAdapter implements ApiAdapter<Yahoo> {

    @Override
    public boolean test(Yahoo api) {
        return false;
    }

    @Override
    public void setConnectionValues(Yahoo api, ConnectionValues values) {

    }

    @Override
    public UserProfile fetchUserProfile(Yahoo api) {
        return null;
    }

    @Override
    public void updateStatus(Yahoo api, String message) {

    }
}
