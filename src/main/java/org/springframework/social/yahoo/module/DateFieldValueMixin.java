package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = JsonTypeInfo.As.WRAPPER_OBJECT)
abstract class DateFieldValueMixin extends FieldValueMixin {

    @JsonProperty("day") int day;
    @JsonProperty("month") int month;
    @JsonProperty("year") int year;
}
