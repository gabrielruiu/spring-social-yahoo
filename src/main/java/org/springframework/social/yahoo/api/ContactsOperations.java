package org.springframework.social.yahoo.api;

import org.springframework.social.yahoo.module.Field;
import org.springframework.social.yahoo.module.FieldType;
import org.springframework.social.yahoo.module.YahooContact;

import java.util.Set;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public interface ContactsOperations {

    Set<Field> getFieldsForContact(YahooContact yahooContact, Set<FieldType> fieldTypes);
}
