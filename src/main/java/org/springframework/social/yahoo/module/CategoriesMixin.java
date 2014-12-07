package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CategoriesMixin extends YahooObjectMixin {

    @JsonProperty("category") List<Category> category;
}
