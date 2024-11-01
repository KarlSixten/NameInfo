package org.example.nameinfo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.nameinfo.entity.Country;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NationalityDTO {
    private String name;
    private int count;
    @JsonProperty("country")
    private List<Country> probableCountries;
}
