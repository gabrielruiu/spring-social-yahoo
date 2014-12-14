package org.springframework.social.yahoo.module;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class SingleFieldValue extends FieldValue {

    private String value;

    public SingleFieldValue() {
    }

    public SingleFieldValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
