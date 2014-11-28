package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class YahooObject {

    private long id;
    private String uri;
    private Date created;
    private Date updated;
    private Map<String, Object> extraData;

    public YahooObject() {
        this.extraData = new HashMap<String, Object>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
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
