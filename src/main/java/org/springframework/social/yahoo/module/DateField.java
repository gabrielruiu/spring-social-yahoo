package org.springframework.social.yahoo.module;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class DateField extends Field {

    private DateFieldValue value;

    @Override
    public Object getValue() {
        return value;
    }

    public void setValue(DateFieldValue value) {
        this.value = value;
    }
}
