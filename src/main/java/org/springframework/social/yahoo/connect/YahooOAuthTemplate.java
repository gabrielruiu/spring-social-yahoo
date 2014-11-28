package org.springframework.social.yahoo.connect;

import org.springframework.social.oauth1.OAuth1Template;
import org.springframework.social.oauth1.OAuth1Version;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.util.MultiValueMap;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
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
        oAuthToken.setAuthorizationExpiresIn(Long.valueOf(response.getFirst(OAUTH_AUTHORIZATION_EXPIRES_IN)));
        oAuthToken.setExpiresIn(Long.valueOf(response.getFirst(OAUTH_EXPIRES_IN)));
        oAuthToken.setSessionHandle(response.getFirst(OAUTH_SESSION_HANDLE));
        oAuthToken.setGuid(response.getFirst(OAUTH_RESPONSE_GUID_KEY));
        this.oAuthToken = oAuthToken;
        return this.oAuthToken;
    }

    public YahooOAuthToken getoAuthToken() {
        return oAuthToken;
    }
}
