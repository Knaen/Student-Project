package com.example.studentproject.service;


import com.example.studentproject.entity.Student;
import com.example.studentproject.exception.CustomException;
import com.example.studentproject.repository.StudentRepository;
import com.example.studentproject.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent != null) {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setAge(student.getAge());
            existingStudent.setCourse(student.getCourse());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPhoneNumber(student.getPhoneNumber());
            existingStudent.setAddress(student.getAddress());
            existingStudent.setGpa(student.getGpa());
            existingStudent.setEnrollmentYear(student.getEnrollmentYear());

            String scholarship = calculateScholarshipStatus(student.getGpa());
            existingStudent.setScholarshipType(scholarship);

            return studentRepository.save(existingStudent);
        }

        return null;
    }

    public String calculateScholarshipStatus(Double gpa) {
        if (gpa == null || gpa < 0 || gpa > 4.0) {
            return "Təyin edilməyib (Yanlış GPA)";
        }
        if (gpa >= 3.5) {
            return "ƏLAÇI (100% Təqaüd)";
        } else if (gpa >= 3.0) {
            return "ZƏRBƏÇİ (50% Təqaüd)";
        } else {
            return "TƏQAÜD ALMIR";
        }
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new CustomException("Tələbə tapılmadı"));

        // Bazadan silmək əvəzinə statusunu "DEACTIVATED" və ya "GRADUATED" edirik
        student.setIsActive(false);
        student.setTerminationDate(LocalDate.now()); // Silinmə və ya xaric olma tarixi

        studentRepository.save(student);
    }

    public Student createStudent(Student student) {
        // Məsələn: Rəşad Məmmədov, 2026-cı il qəbulu -> reshad.mammadov2026@uni.edu.az
        String generatedEmail = student.getFirstName().toLowerCase() + "." +
                student.getLastName().toLowerCase() +
                student.getEnrollmentYear() + "@uni.edu.az";

        // Unikal Tələbə nömrəsi: STU2026001 (Random və ya sıra nömrəsi ilə)
        String studentCode = "STU" + student.getEnrollmentYear() + (long)(Math.random() * 1000);

        student.setEmail(generatedEmail);
        student.setStudentCode(studentCode);
        student.setIsActive(true);

        return studentRepository.save(student);
    }
}
