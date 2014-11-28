package org.springframework.social.yahoo.module;

import java.util.Set;

/**
 * A contact resource contains information about a user who is known, perhaps through
 * an email exchange, to another user. Contacts are just like entries in an address book.
 * The person who is listed as a contact does not have to give his or her approval.
 * For example, Joe can add everyone from his school to his address book, and he does not
 * need to ask each of them for permission to be added to his list of contacts.
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/contact-resource.html">Contact resource</a>
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
//TODO: use personal email instead of work email
public class YahooContact extends YahooObject {

    private boolean isConnection;
    private Set<Field> fields;
    private Set<Category> categories;

    public boolean isConnection() {
        return isConnection;
    }

    public void setConnection(boolean isConnection) {
        this.isConnection = isConnection;
    }

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
