package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CategoryMixin extends YahooObjectMixin {

    @JsonProperty("id") int id;

    @JsonProperty("name") String name;

    @JsonProperty("created") Date created;

    @JsonProperty("updated") Date updated;

    @JsonProperty("uri") String uri;

}
