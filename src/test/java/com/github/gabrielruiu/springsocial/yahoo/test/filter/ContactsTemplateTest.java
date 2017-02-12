package com.github.gabrielruiu.springsocial.yahoo.test.filter;

import com.github.gabrielruiu.springsocial.yahoo.api.impl.ContactsTemplate;
import com.github.gabrielruiu.springsocial.yahoo.module.Contact;
import com.github.gabrielruiu.springsocial.yahoo.module.Field;
import com.github.gabrielruiu.springsocial.yahoo.module.FieldType;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
public abstract class ContactsTemplateTest extends WiremockTest {

	protected Field getField(Contact contact, FieldType fieldType) {
		for (Field field : contact.getFields()) {
			if (field.getType().equals(fieldType)) {
				return field;
			}
		}
		return null;
	}

	protected ContactsTemplate contactsTemplate() {
		return new ContactsTemplate(restTemplate(), true, GUID) {
			@Override
			protected String getApiUrlBase() {
				return apiUrlBaseForTest();
			}
		};
	}
}
