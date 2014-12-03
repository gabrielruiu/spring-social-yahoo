package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class FieldTypeDeserializer extends JsonDeserializer<FieldType> {

    @Override
    public FieldType deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String fieldTypeString = jp.getValueAsString();
        return FieldType.valueOf(fieldTypeString.toUpperCase());
    }
}
