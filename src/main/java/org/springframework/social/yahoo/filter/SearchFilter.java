package org.springframework.social.yahoo.filter;

import org.springframework.social.yahoo.module.FieldType;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.social.yahoo.filter.TokenUtils.SYMBOL_EQUALS;
import static org.springframework.social.yahoo.filter.TokenUtils.SYMBOL_PERIOD;
import static org.springframework.social.yahoo.filter.TokenUtils.SYMBOL_SEMICOLON;
import static org.springframework.social.yahoo.filter.TokenUtils.shouldAddTokenSeparator;
import static org.springframework.social.yahoo.module.FieldType.NAME;

/**
 * Implementation of {@link ContactsRequestCustomizer} that builds a filter for the Contacts resource, such that only
 * those contacts which respect the conditions, will be returned from the Yahoo Contacts API.
 *
 * There are two types of SearchFilters
 * - AND search filter
 * - OR search filter
 *
 * The AND search filter constructs the request parameters such that, only those Contacts which respect ALL of the
 * conditions will be included in the response.
 *
 * The OR search filter constructs the request parameters such that, only those Contacts which respect AT LEAST ONE of
 * the conditions will be included in the response.
 *
 * Both types of filters can be combined.
 *
 * @see {@link ContactsFilter#withAndFilter(FieldType, SearchFilterConstraint, String)}
 * @see {@link ContactsFilter#withAndFilter(SearchableField, SearchFilterConstraint, String)}
 * @see {@link ContactsFilter#withOrFilter(FieldType, SearchFilterConstraint, String)}
 * @see {@link ContactsFilter#withOrFilter(SearchableField, SearchFilterConstraint, String)}
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class SearchFilter extends ContactsRequestCustomizer {

    private static final List<String> SEARCHABLE_FIELDS = searchableFields();
    private String tokenSeparator;

    /**
     * By default, an 'AND' search filter is constructed
     */
    public SearchFilter() {
        this.tokenSeparator = SYMBOL_SEMICOLON;
    }

    public SearchFilter(String tokenSeparator) {
        this.tokenSeparator = tokenSeparator;
    }

    public void addField(FieldType fieldType, SearchFilterConstraint key, String constraintValue) {
        addToken(fieldType.name().toLowerCase(), key, constraintValue);
    }

    public void addField(SearchableField field, SearchFilterConstraint key, String constraintValue) {
        addToken(field.getParameterName(), key, constraintValue);
    }

    private void addToken(String fieldName, SearchFilterConstraint key, String constraintValue) {
        addToken(new CustomizerToken(fieldName, key.getKey(), constraintValue));
    }

    @Override
    public boolean isFieldAllowed(String fieldName) {
        return SEARCHABLE_FIELDS.contains(fieldName);
    }

    @Override
    public String toRequest() {
        StringBuilder sb = new StringBuilder();
        if (hasTokens()) {
            List<CustomizerToken> tokens = getTokens();
            for (CustomizerToken token : tokens) {
                sb.append(token.getFieldName())
                        .append(SYMBOL_PERIOD)
                        .append(token.getKey())
                        .append(SYMBOL_EQUALS)
                        .append(token.getValue());
                if (shouldAddTokenSeparator(tokens, token)) {
                    sb.append(tokenSeparator);
                }
            }
        }
        return sb.toString();
    }

    /**
     * Only SearchableField and FieldTypes(except NAME) can be searched for
     */
    private static List<String> searchableFields() {
        List<String> searchableFields = new ArrayList<>();
        for (FieldType fieldType : FieldType.values()) {
            if (!fieldType.equals(NAME)) {
                searchableFields.add(fieldType.name().toLowerCase());
            }
        }
        for (SearchableField searchableField : SearchableField.values()) {
            searchableFields.add(searchableField.getParameterName());
        }
        return searchableFields;
    }

    public static enum SearchableField {

        NAME_GIVEN_NAME("givenName"),
        NAME_MIDDLE_NAME("middleName"),
        NAME_FAMILY_NAME("familyName"),
        NAME_PREFIX("prefix"),
        NAME_SUFFIX("suffix"),
        NAME_GIVEN_NAME_SOUND("givenNameSound"),
        NAME_FAMILY_NAME_SOUND("familyNameSound"),
        /**
         * matches all field names in a Contact Object
         */
        ALL("all"),
        /**
         * matches the category name of the Category Object that is part of the Contact Object
         */
        CATEGORY("category"),
        /**
         * matches all the field names of Contact Object, except the category name of Category Objects
         */
        ALL_BUT_CATEGORY("all-but-category");

        private String parameterName;

        SearchableField(String parameterName) {
            this.parameterName = parameterName;
        }

        public String getParameterName() {
            return parameterName;
        }
    }
    public static enum SearchFilterConstraint {
        /**
         * Case-insensitive comparison of a Contact Object's field value with the given value of
         * the search criteria
         */
        IS("is"),
        /**
         * Case-insensitive comparison of the beginning of a Contact Object's field value with the given
         * value of the search criteria
         */
        STARTS_WITH("startsWith"),
        /**
         * Case-insensitive comparison of a substring in a Contact Object's field value with the given
         * value of the search criteria
         */
        CONTAINS("contains"),
        /**
         * Case-sensitive comparison of a Contact Object's field value with the given value of the
         * search criteria (same as is)
         */
        CS_IS("cs-is"),
        /**
         * Case-sensitive comparison of the beginning of a Contact Object's field value with the given
         * value of the search criteria
         */
        CS_STARTSWITH("cs-startswith"),
        /**
         * Case-sensitive comparison of a substring in Contact Object's field value with the given value
         * of the search criteria
         */
        CS_CONTAINS("cs-contains"),
        /**
         * If the given value is 1, match if the field is present in the Contact Object. If the given
         * value is 0, match if the field is not present in the Contact Object
         */
        PRESENT("present");

        private String key;

        SearchFilterConstraint(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

}
