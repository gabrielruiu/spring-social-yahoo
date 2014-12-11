package org.springframework.social.yahoo.filter;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class CustomizerToken {

    private String fieldName;
    private String key;
    private String value;

    public CustomizerToken(String fieldName, String key, String value) {
        this.fieldName = fieldName;
        this.key = key;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
