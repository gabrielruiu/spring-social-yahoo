/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.yahoo.filter;

import org.springframework.social.yahoo.api.ContactsOperations;
import org.springframework.social.yahoo.filter.SearchFilter.SearchFilterConstraint;
import org.springframework.social.yahoo.filter.SearchFilter.SearchableField;
import org.springframework.social.yahoo.filter.SortFields.SortableField;
import org.springframework.social.yahoo.module.FieldType;

import static org.springframework.social.yahoo.filter.TokenUtils.SYMBOL_COMMA;
import static org.springframework.social.yahoo.filter.TokenUtils.SYMBOL_SEMICOLON;

/**
 * Convenience class that unites all of the classes which are responsible for building request parameters which
 * either filter or sort Contact objects.
 * This can only be used when request the Contacts resource.
 *
 * @see {@link ContactsOperations#getContacts(ContactsFilter)}
 *
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class ContactsFilter {

    private SearchFilter orSearchFilter = new SearchFilter(SYMBOL_COMMA);
    private SearchFilter andSearchFilter = new SearchFilter(SYMBOL_SEMICOLON);
    private SortFields sortFields = new SortFields();
    private SortOrder sortOrder = new SortOrder();
    private DisplayFilter displayFilter = new DisplayFilter();

    /**
     * Only those contacts which respect AT LEAST ONE of the conditions will be added to the response.
     * Can be combined with:
     *    {@link #withOrFilter(SearchableField, SearchFilterConstraint, String)}
     *    {@link #withAndFilter(FieldType, SearchFilterConstraint, String)}
     *    {@link #withAndFilter(SearchableField, SearchFilterConstraint, String)}
     */
    public ContactsFilter withOrFilter(FieldType fieldType, SearchFilterConstraint key, String condition) {
        orSearchFilter.addField(fieldType, key, condition);
        return this;
    }

    /**
     * Only those contacts which respect AT LEAST ONE of the conditions will be added to the response.
     * Can be combined with:
     *    {@link #withOrFilter(FieldType, SearchFilterConstraint, String)}
     *    {@link #withAndFilter(FieldType, SearchFilterConstraint, String)}
     *    {@link #withAndFilter(SearchableField, SearchFilterConstraint, String)}
     */
    public ContactsFilter withOrFilter(SearchableField field, SearchFilterConstraint key, String condition) {
        orSearchFilter.addField(field, key, condition);
        return this;
    }

    /**
     * Only those contacts which respect ALL of the conditions will be added to the response.
     * Can be combined with:
     *    {@link #withAndFilter(SearchableField, SearchFilterConstraint, String)}
     *    {@link #withOrFilter(FieldType, SearchFilterConstraint, String)}
     *    {@link #withOrFilter(SearchableField, SearchFilterConstraint, String)}
     */
    public ContactsFilter withAndFilter(FieldType fieldType, SearchFilterConstraint key, String condition) {
        andSearchFilter.addField(fieldType, key, condition);
        return this;
    }

    /**
     * Only those contacts which respect ALL of the conditions will be added to the response.
     * Can be combined with:
     *    {@link #withAndFilter(FieldType, SearchFilterConstraint, String)}
     *    {@link #withOrFilter(FieldType, SearchFilterConstraint, String)}
     *    {@link #withOrFilter(SearchableField, SearchFilterConstraint, String)}
     */
    public ContactsFilter withAndFilter(SearchableField field, SearchFilterConstraint key, String condition) {
        andSearchFilter.addField(field, key, condition);
        return this;
    }

    /**
     * Only the specified fields are retrieved for each Contact object, no matter if there are other non-empty fields.
     */
    public ContactsFilter displaySelectedFields(FieldType... fieldTypes) {
        displayFilter.addFields(fieldTypes);
        return this;
    }

    /**
     * All fields from a Contact object, which have a non-empty value, are included in the response.
     */
    public ContactsFilter displayAllFields() {
        displayFilter.addAllFields();
        return this;
    }

    /**
     * Specifies by which fields the Contacts should be ordered; FieldType.NAME and FieldType.ADDRESS are not allowed
     * when sorting.
     * If you want to sort by name, use {@link SortableField}.
     * Can be combined with {@link #sortBy(SortableField...)}
     */
    public ContactsFilter sortBy(FieldType... fieldTypes) {
        sortFields.addFields(fieldTypes);
        return this;
    }

    /**
     * Specifies by which fields the Contacts should be ordered; all {@link SortableField}s are allowed.
     * Can be combined with {@link #sortBy(FieldType...)}
     */
    public ContactsFilter sortBy(SortableField... sortableFields) {
        sortFields.addFields(sortableFields);
        return this;
    }

    /**
     * Order ascending or descending the Contacts.
     * Must be accompanied by calls to {@link #sortBy(FieldType...)} or {@link #sortBy(SortableField...)}
     */
    public ContactsFilter sortOrder(SortOrder.Order order) {
        sortOrder.setOrder(order);
        return this;
    }

    /**
     * Concatenates each of the request parameters built by each filter, which is then appended to the request for
     * the Contacts resource
     */
    public String build() {
        StringBuilder sb = new StringBuilder();
        if (orSearchFilter.hasTokens()) {
            sb.append(orSearchFilter.toRequest());
        }
        if (andSearchFilter.hasTokens()) {
            sb.append(SYMBOL_SEMICOLON);
            sb.append(andSearchFilter.toRequest());
        }
        if (displayFilter.hasTokens()) {
            sb.append(SYMBOL_SEMICOLON);
            sb.append(displayFilter.toRequest());
        }
        if (sortFields.hasTokens()) {
            sb.append(SYMBOL_SEMICOLON);
            sb.append(sortFields.toRequest());
        }
        if (sortOrder.hasTokens()) {
            sb.append(SYMBOL_SEMICOLON);
            sb.append(sortOrder.toRequest());
        }
        return sb.toString();
    }
}
