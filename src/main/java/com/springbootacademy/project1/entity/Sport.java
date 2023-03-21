package com.springbootacademy.project1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Sport")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Sport {

    @Id
    @Column(name = "sport_id",length = 100,nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sportId;

    @Column(name = "sport_name",length = 100,nullable = false)
    private String sportName;

    @Column(name = "sport_in_charge",length = 100,nullable = false)
    private String inChargeName;

    @Column(name = "practise_day",nullable = false)
    private String practiseDay;

    @Column(name = "grade_range",length = 100,nullable = false)
    private String gradeRange;

}
