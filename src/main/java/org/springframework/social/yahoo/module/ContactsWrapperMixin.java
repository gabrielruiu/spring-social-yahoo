package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
abstract class ContactsWrapperMixin {

    @JsonProperty("contacts") Contacts contacts;
}
