package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SingleFieldValueMixin extends FieldValue {

    @JsonProperty("value") String value;
}
