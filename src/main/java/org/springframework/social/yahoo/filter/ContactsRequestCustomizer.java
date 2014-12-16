package org.springframework.social.yahoo.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Parent class used for constructing request parameters for filtering and sorting the Contact objects from the
 * Contacts resource.
 *
 * Each implementation of this class needs to know:
 * - which fields it can work with; some filtering or sorting operations can only work on a subset of fields
 * (check the documentation for each of the filters)
 * - how to build the request from the {@link CustomizerToken}s; each implementation decides what properties it needs
 * from the {@link CustomizerToken} to build the request
 *
 * @see {@link DisplayFilter}
 * @see {@link SearchFilter}
 * @see {@link SortOrder}
 * @see {@link SortFields}
 *
 * @see {@link ContactsFilter}
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
