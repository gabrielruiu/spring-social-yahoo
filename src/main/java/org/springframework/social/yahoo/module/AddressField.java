package org.springframework.social.yahoo.module;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class AddressField extends Field {

    private AddressFieldValue value;

    @Override
    public AddressFieldValue getValue() {
        return value;
    }

    public void setValue(AddressFieldValue value) {
        this.value = value;
    }
}
