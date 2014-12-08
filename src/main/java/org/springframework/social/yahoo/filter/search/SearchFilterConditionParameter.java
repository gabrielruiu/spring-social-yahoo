package org.springframework.social.yahoo.filter.search;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public enum SearchFilterConditionParameter {
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

    private String parameterName;

    SearchFilterConditionParameter(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterName() {
        return parameterName;
    }
}
