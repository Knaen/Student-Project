package com.example.studentproject.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class Subject {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "credit")
    private Integer credit;

    @Column(name = "description")
    private String description;

    @Column(name = "department")
    private String department;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "hours_per_week")
    private Integer hoursPerWeek;

    @Column(name = "is_active")
    private Boolean isActive;
}
