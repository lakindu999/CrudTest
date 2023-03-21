package com.springbootacademy.project1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SportDTO {

    private int sportId;
    private String sportName;
    private String inChargeName;
    private String practiseDay;
    private String gradeRange;
}
