package com.example.studentproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDto {

    private Long id;
    private String subjectName;
    private String subjectCode;
    private Integer credit;
    private String description;
    private String department;
    private Integer semester;
    private String teacherName;
    private Integer hoursPerWeek;
    private Boolean isActive;

}
