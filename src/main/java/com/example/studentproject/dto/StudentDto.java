package com.example.studentproject.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer course;
    private String email;
    private String phoneNumber;
    private Double gpa;
    private Integer enrollmentYear;
}
