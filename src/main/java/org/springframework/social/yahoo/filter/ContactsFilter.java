package org.springframework.social.yahoo.filter;

/**
 * Filters can only be used when calling the HTTP GET method of the Contacts URI.
 *
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/contacts_resource-filters.html">Contact filtering</a>
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public interface ContactsFilter {

    String buildFilter();
}
