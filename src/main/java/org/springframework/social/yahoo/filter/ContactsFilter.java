package org.springframework.social.yahoo.filter;

import org.springframework.social.yahoo.module.FieldType;

/**
 * Filters can only be used when calling the HTTP GET method of the Contacts URI.
 * If you call GET without a filter, you get a response including all of the contacts
 * from the authenticated user's list of contacts.
 *
 * If you call GET with a search filter, you get a response including a subset of the
 * authenticated user's contacts.
 *
 * Display filtering allows you to select specific information for each returned contact.
 *
 * Search and display filtering can be used independently or conjunctively.
 * Filters use criteria that include two components: a predefined set of keys and user-defined
 * values.
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/contacts_resource-filters.html">Contact filtering</a>
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class ContactsFilter {

    private SearchFilter orSearchFilter = new OrSearchFilter();
    private SearchFilter andSearchFilter = new AndSearchFilter();
    private SortFields sortFields = new SortFields();
    private SortOrder sortOrder = new SortOrder();
    private DisplayFilter displayFilter = new DisplayFilter();

    public ContactsFilter withOrFilter(FieldType fieldType, SearchFilter.SearchFilterKey key, String condition) {
        orSearchFilter.addField(fieldType, key, condition);
        return this;
    }

    public ContactsFilter withOrFilter(SearchFilter.SearchableField field, SearchFilter.SearchFilterKey key, String condition) {
        orSearchFilter.addField(field, key, condition);
        return this;
    }

    public ContactsFilter withAndFilter(FieldType fieldType, SearchFilter.SearchFilterKey key, String condition) {
        andSearchFilter.addField(fieldType, key, condition);
        return this;
    }

    public ContactsFilter withAndFilter(SearchFilter.SearchableField field, SearchFilter.SearchFilterKey key, String condition) {
        andSearchFilter.addField(field, key, condition);
        return this;
    }


    public ContactsFilter displaySelectedFields(FieldType... fieldTypes) {
        displayFilter.addFields(fieldTypes);
        return this;
    }

    public ContactsFilter displayAllFields() {
        displayFilter.addAllFields();
        return this;
    }

    public ContactsFilter sortBy(FieldType... fieldTypes) {
        sortFields.addFields(fieldTypes);
        return this;
    }

    public ContactsFilter sortBy(SortFields.SortableField... sortableFields) {
        sortFields.addFields(sortableFields);
        return this;
    }

    public ContactsFilter sortOrder(SortOrder.Order order) {
        sortOrder.setOrder(order);
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        if (orSearchFilter.hasTokens()) {
            sb.append(orSearchFilter.toRequest());
        }
        if (andSearchFilter.hasTokens()) {
            sb.append(";");
            sb.append(andSearchFilter.toRequest());
        }
        if (displayFilter.hasTokens()) {
            sb.append(";");
            sb.append(displayFilter.toRequest());
        }
        if (sortFields.hasTokens()) {
            sb.append(";");
            sb.append(sortFields.toRequest());
        }
        if (sortOrder.hasTokens()) {
            sb.append(";");
            sb.append(sortOrder.toRequest());
        }
        return sb.toString();
    }

}
