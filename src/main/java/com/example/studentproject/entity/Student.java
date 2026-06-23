package com.example.studentproject.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table
@Getter
@Setter
public class Student {

    @Id
    @Column(name = "id")

    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "course")
    private Integer course;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "gpa")
    private Double gpa;

    private Boolean isActive;

    private LocalDate TerminationDate;
    @Column(name = "enrollment_year")
    private Integer enrollmentYear;

    private String studentCode;
    private List<Subject> subjects;

    private String scholarshipType;

    public Optional<List<Subject>> getSubjects() {
        return Optional.ofNullable(this.subjects);
    }
}
