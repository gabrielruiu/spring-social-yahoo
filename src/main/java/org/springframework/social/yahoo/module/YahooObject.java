package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class YahooObject {

    private Map<String, Object> extraData;

    public YahooObject() {
        this.extraData = new HashMap<String, Object>();
    }

    /**
     * @return Any fields in response from Twitter that are otherwise not mapped to any properties.
     */
    public Map<String, Object> getExtraData() {
        return extraData;
    }

    /**
     * {@link JsonAnySetter} hook. Called when an otherwise unmapped property is being processed during JSON deserialization.
     * @param key The property's key.
     * @param value The property's value.
     */
    protected void add(String key, Object value) {
        extraData.put(key, value);
    }
}
