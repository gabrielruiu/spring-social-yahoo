package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = JsonTypeInfo.As.WRAPPER_OBJECT)
abstract class NameFieldValueMixin extends FieldValue {

    @JsonProperty("givenName") String givenName;

    @JsonProperty("middleName") String middleName;

    @JsonProperty("familyName") String familyName;

    @JsonProperty("prefix") String prefix;

    @JsonProperty("suffix") String suffix;

    @JsonProperty("givenNameSound") String givenNameSound;

    @JsonProperty("familyNameSound") String familyNameSound;
}
