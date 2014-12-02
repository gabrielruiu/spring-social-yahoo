package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class DateFieldValueMixin extends FieldValueMixin {

    @JsonProperty("day") int day;
    @JsonProperty("month") int month;
    @JsonProperty("year") int year;
}
