package org.springframework.social.yahoo.filter;

import org.springframework.social.yahoo.module.FieldType;

import java.util.List;

import static org.springframework.social.yahoo.filter.TokenUtils.SYMBOL_COMMA;
import static org.springframework.social.yahoo.filter.TokenUtils.SYMBOL_EQUALS;
import static org.springframework.social.yahoo.filter.TokenUtils.shouldAddTokenSeparator;

/**
 * Implementation of {@link RequestCustomizer} that builds a filter for the Contacts resource, such that only
 * the specified fields will be retrieved for each Contact. The Contact object
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class DisplayFilter extends RequestCustomizer {

    private static final String DISPLAY_FILTER_KEY = "out";

    public void addFields(FieldType... fieldTypes) {
        for (FieldType type : fieldTypes) {
            String fieldName = type.name().toLowerCase();
            addToken(new CustomizerToken(fieldName, null, fieldName));
        }
    }

    public void addAllFields() {
        getTokens().clear();
        addToken(new CustomizerToken(Display.ALL.name().toLowerCase(), null, Display.ALL.name().toLowerCase()));
    }

    @Override
    public boolean isFieldAllowed(String fieldName) {
        return true;
    }

    @Override
    public String toRequest() {
        StringBuilder sb = new StringBuilder();
        if (hasTokens()) {
            sb.append(DISPLAY_FILTER_KEY).append(SYMBOL_EQUALS);
            List<CustomizerToken> tokens = getTokens();
            for (CustomizerToken token : tokens) {
                sb.append(token.getValue());
                if (shouldAddTokenSeparator(tokens, token)) {
                    sb.append(SYMBOL_COMMA);
                }
            }
        }
        return sb.toString();
    }

    public static enum Display {
        ALL
    }
}
