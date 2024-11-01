package org.example.nameinfo.entity;

import lombok.*;
import org.example.nameinfo.dto.AgeDTO;
import org.example.nameinfo.dto.GenderDTO;
import org.example.nameinfo.dto.NationalityDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NameInfo {
    private AgeDTO ageDTO;
    private GenderDTO genderDTO;
    private NationalityDTO nationalityDTO;
}
