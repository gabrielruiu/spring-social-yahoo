package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class NameFieldValueMixin extends FieldValue {

    @JsonProperty("givenName") String givenName;

    @JsonProperty("middleName") String middleName;

    @JsonProperty("familyName") String familyName;

    @JsonProperty("prefix") String prefix;

    @JsonProperty("suffix") String suffix;

    @JsonProperty("givenNameSound") String givenNameSound;

    @JsonProperty("familyNameSound") String familyNameSound;
}
