package org.springframework.social.yahoo.connect;

import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;
import org.springframework.social.yahoo.api.Yahoo;
import org.springframework.social.yahoo.api.impl.YahooTemplate;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class YahooServiceProvider extends AbstractOAuth1ServiceProvider<Yahoo> {

    //TODO: get requestTokenUrl, authorizeUrl, authenticationUrl
    public YahooServiceProvider(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret, new OAuth1Template(consumerKey, consumerSecret,
                "requestTokenUrl",
                "authorizeUrl",
                "authenticationUrl"));
    }

    @Override
    public Yahoo getApi(String accessToken, String secret) {
        return new YahooTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
    }
}
