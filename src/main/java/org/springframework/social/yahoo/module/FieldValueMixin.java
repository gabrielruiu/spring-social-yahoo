package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type",
        defaultImpl = SingleFieldValue.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AddressFieldValue.class, name = "address"),
        @JsonSubTypes.Type(value = NameFieldValue.class, name = "name"),
        @JsonSubTypes.Type(value = DateFieldValue.class, name = "anniversary"),
        @JsonSubTypes.Type(value = DateFieldValue.class, name = "birthday"),
        @JsonSubTypes.Type(value = SingleFieldValue.class, name = "guid"),
        @JsonSubTypes.Type(value = SingleFieldValue.class, name = "nickname"),
        @JsonSubTypes.Type(value = SingleFieldValue.class, name = "email"),
        @JsonSubTypes.Type(value = SingleFieldValue.class, name = "yahooid"),
        @JsonSubTypes.Type(value = SingleFieldValue.class, name = "otherid"),
        @JsonSubTypes.Type(value = SingleFieldValue.class, name = "phone"),
        @JsonSubTypes.Type(value = SingleFieldValue.class, name = "jobtitle"),
        @JsonSubTypes.Type(value = SingleFieldValue.class, name = "company"),
        @JsonSubTypes.Type(value = SingleFieldValue.class, name = "notes"),
        @JsonSubTypes.Type(value = SingleFieldValue.class, name = "link"),
        @JsonSubTypes.Type(value = SingleFieldValue.class, name = "custom")
})
abstract class FieldValueMixin {
}
