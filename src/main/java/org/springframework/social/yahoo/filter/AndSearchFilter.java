package org.springframework.social.yahoo.filter;

import static org.springframework.social.yahoo.filter.TokenConstants.SYMBOL_SEMICOLON;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class AndSearchFilter extends SearchFilter {

    public AndSearchFilter() {
        super(SYMBOL_SEMICOLON);
    }
}
