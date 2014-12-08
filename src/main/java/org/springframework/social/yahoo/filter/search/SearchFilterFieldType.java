package org.springframework.social.yahoo.filter.search;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public enum SearchFilterFieldType {

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

    SearchFilterFieldType(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterName() {
        return parameterName;
    }
}
