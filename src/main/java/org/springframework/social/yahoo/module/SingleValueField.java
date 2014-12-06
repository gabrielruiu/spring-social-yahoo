package org.springframework.social.yahoo.module;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
//TODO: better names for SingleValueField and SingleFieldValue
public class SingleValueField extends Field {

    private SingleFieldValue value;

    @Override
    public Object getValue() {
        return value;
    }

    public void setValue(SingleFieldValue value) {
        this.value = value;
    }
}
