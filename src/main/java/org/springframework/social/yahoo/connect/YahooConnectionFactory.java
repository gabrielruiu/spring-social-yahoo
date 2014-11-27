package org.springframework.social.yahoo.connect;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.yahoo.api.Yahoo;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
//TODO: add copyright for classes that dont have any
public class YahooConnectionFactory extends OAuth1ConnectionFactory<Yahoo> {

    public YahooConnectionFactory(String consumerKey, String consumerSecret) {
        super("yahoo", new YahooServiceProvider(consumerKey, consumerSecret) , new YahooAdapter());
    }
}
