package org.example.nameinfo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Country {
    @JsonProperty("country_id")
    private String countryID;
    @JsonProperty("probability")
    private String countryProbability;
}
