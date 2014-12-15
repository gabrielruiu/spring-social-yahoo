package org.springframework.social.yahoo.module;

/**
 * Utility class to ease the retrieval of certain fields from a Contact object.
 *
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
class ContactFieldUtils  {

    public static DateFieldValue getDateValue(Contact contact, FieldType fieldType) {
        DateField dateField = (DateField) getField(contact, fieldType);
        if (dateField != null) {
            return dateField.getValue();
        }
        return null;
    }

    public static NameFieldValue getNameValue(Contact contact) {
        NameField nameField = (NameField) getField(contact, FieldType.NAME);
        if (nameField != null) {
            return nameField.getValue();
        }
        return null;
    }

    public static String getValueFromSingleValueField(Contact contact, FieldType fieldType) {
        return getValueFromSingleField(getField(contact, fieldType));
    }

    private static String getValueFromSingleField(Field field) {
        SingleValueField singleValueField = (SingleValueField) field;
        if (field != null) {
            return ((SingleFieldValue) singleValueField.getValue()).getValue();
        }
        return null;
    }

    private static Field getField(Contact contact, FieldType fieldType) {

        for (Field field : contact.getFields()) {
            if (field.getType().equals(fieldType)) {
                return field;
            }
        }
        return null;
    }
}
