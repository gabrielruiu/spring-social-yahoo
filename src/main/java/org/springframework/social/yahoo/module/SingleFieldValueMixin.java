package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SingleFieldValueMixin extends FieldValue {

    @JsonProperty("value") String value;

    @JsonCreator
    public SingleFieldValueMixin(String value) {
        this.value = value;
    }
}
