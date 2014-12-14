package org.springframework.social.yahoo.filter;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class OrSearchFilter extends SearchFilter {

    public OrSearchFilter() {
        super(OR_TOKEN_SEPARATOR);
    }
}
