package com.example.studentproject.dto;

import com.example.studentproject.entity.Student;
import com.example.studentproject.entity.Subject;

public class EntityMapper {

    // Student -> DTO
    public static StudentDto toStudentDTO(Student student) {
        if (student == null) return null;

        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setAge(student.getAge());
        dto.setCourse(student.getCourse());
        dto.setEmail(student.getEmail());
        dto.setPhoneNumber(student.getPhoneNumber());
        dto.setGpa(student.getGpa());
        dto.setEnrollmentYear(student.getEnrollmentYear());

        return dto;
    }

    // DTO -> Student
    public static Student toStudentEntity(StudentDto dto) {
        if (dto == null) return null;

        Student student = new Student();
        student.setId(dto.getId());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setAge(dto.getAge());
        student.setCourse(dto.getCourse());
        student.setEmail(dto.getEmail());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setGpa(dto.getGpa());
        student.setEnrollmentYear(dto.getEnrollmentYear());

        return student;
    }

    // Subject -> DTO
    public static SubjectDto toSubjectDTO(Subject subject) {
        if (subject == null) return null;

        SubjectDto dto = new SubjectDto();
        dto.setId(subject.getId());
        dto.setSubjectName(subject.getSubjectName());
        dto.setSubjectCode(subject.getSubjectCode());
        dto.setCredit(subject.getCredit());
        dto.setDescription(subject.getDescription());
        dto.setDepartment(subject.getDepartment());
        dto.setSemester(subject.getSemester());
        dto.setTeacherName(subject.getTeacherName());
        dto.setHoursPerWeek(subject.getHoursPerWeek());
        dto.setIsActive(subject.getIsActive());

        return dto;
    }

    // DTO -> Subject
    public static Subject toSubjectEntity(SubjectDto dto) {
        if (dto == null) return null;

        Subject subject = new Subject();
        subject.setId(dto.getId());
        subject.setSubjectName(dto.getSubjectName());
        subject.setSubjectCode(dto.getSubjectCode());
        subject.setCredit(dto.getCredit());
        subject.setDescription(dto.getDescription());
        subject.setDepartment(dto.getDepartment());
        subject.setSemester(dto.getSemester());
        subject.setTeacherName(dto.getTeacherName());
        subject.setHoursPerWeek(dto.getHoursPerWeek());
        subject.setIsActive(dto.getIsActive());

        return subject;
    }
}
