package org.springframework.social.yahoo.filter;

import org.springframework.social.yahoo.module.FieldType;

import java.util.List;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class SearchFilter extends RequestCustomizer {

    public void addField(FieldType fieldType, SearchFilterKey key, String condtition) {
        addToken(fieldType.name().toLowerCase(), key, condtition);
    }

    public void addField(SearchableField field, SearchFilterKey key, String condtition) {
        addToken(field.getParameterName(), key, condtition);
    }

    private void addToken(String fieldName, SearchFilterKey key, String condtition) {
        addToken(new CustomizerToken(fieldName, key.getKey(), condtition));
    }

    @Override
    public boolean isFieldAllowed(String fieldName) {
        return !fieldName.equals(FieldType.NAME.name().toLowerCase());
    }

    @Override
    public String toRequest() {
        StringBuilder sb = new StringBuilder();
        List<CustomizerToken> tokens = getTokens();
        for (CustomizerToken token : tokens) {

        }
        return sb.toString();
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

    public static enum SearchFilterKey {
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

        SearchFilterKey(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

}
