package org.springframework.social.yahoo.filter;

import static org.springframework.social.yahoo.filter.TokenConstants.SYMBOL_COMMA;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class OrSearchFilter extends SearchFilter {

    public OrSearchFilter() {
        super(SYMBOL_COMMA);
    }
}
