package org.springframework.social.yahoo.filter;

/**
 * Filters can only be used when calling the HTTP GET method of the Contacts URI.
 *
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public interface ContactsFilter {

    String buildFilter();
}
