package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type", visible = true)
abstract class FieldValueMixin {
}
