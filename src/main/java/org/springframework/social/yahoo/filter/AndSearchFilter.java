package org.springframework.social.yahoo.filter;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class AndSearchFilter extends SearchFilter {

    public AndSearchFilter() {
        super(AND_TOKEN_SEPARATOR);
    }
}
