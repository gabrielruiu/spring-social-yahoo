package org.springframework.social.yahoo.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Parent class used to construct request parameters for filtering and
 * sorting calls to the Contacts API.
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public abstract class ContactsRequestCustomizer {

    public List<CustomizerToken> tokens = new ArrayList<>();

    protected final void addToken(CustomizerToken token) {
        if (isFieldAllowed(token.getFieldName())) {
            tokens.add(token);
        } else {
            throw new IllegalArgumentException(String.format("Token with fieldName=%s not " +
                    "allowed", token.getFieldName()));
        }
    }

    public List<CustomizerToken> getTokens() {
        return tokens;
    }

    public boolean hasTokens() {
        return tokens.size() > 0;
    }

    public abstract boolean isFieldAllowed(String fieldName);

    public abstract String toRequest();
}
