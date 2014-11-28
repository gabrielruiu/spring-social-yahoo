package org.springframework.social.yahoo.connect;

import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.yahoo.api.Yahoo;
import org.springframework.social.yahoo.api.impl.YahooTemplate;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class YahooServiceProvider extends AbstractOAuth1ServiceProvider<Yahoo> {

    private String guid;

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
