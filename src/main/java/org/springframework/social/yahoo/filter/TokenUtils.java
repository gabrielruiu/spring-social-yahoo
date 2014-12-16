package org.springframework.social.yahoo.filter;

import java.util.List;

/**
 * Utility class for helping with general operations with tokens
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class TokenUtils {

    public static final String SYMBOL_COMMA = ",";
    public static final String SYMBOL_SEMICOLON = ";";
    public static final String SYMBOL_EQUALS = "=";
    public static final String SYMBOL_PERIOD = ".";

    private TokenUtils() {
    }

    /**
     * Determines, when traversing and serializing a list of tokens, if the current token is not the last
     * one, and a separator can be added;
     */
    public static boolean shouldAddTokenSeparator(List<CustomizerToken> tokens, CustomizerToken token) {
        if (!tokens.contains(token)) {
            throw new IllegalArgumentException("Token must be part of token list");
        }
        return tokens.size() > 1 && !token.equals(tokens.get(tokens.size() - 1));
    }
}
