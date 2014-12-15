package org.springframework.social.yahoo.module;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class NameField extends Field {

    private NameFieldValue value;

    @Override
    public NameFieldValue getValue() {
        return value;
    }

    public void setValue(NameFieldValue value) {
        this.value = value;
    }
}
