package org.example.nameinfo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GenderDTO {
    private String gender;
    private String name;
    private int count;
    private double probability;
}
