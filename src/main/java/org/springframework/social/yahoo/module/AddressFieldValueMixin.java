package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class AddressFieldValueMixin {

    @JsonProperty("street") String street;

    @JsonProperty("city") String city;

    @JsonProperty("stateOrProvince") String stateOrProvince;

    @JsonProperty("country") String country;

    @JsonProperty("postalCode") String postalCode;

    @JsonProperty("countryCode") String countryCode;
}
