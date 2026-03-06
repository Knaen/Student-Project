package com.example.studentproject.service;


import com.example.studentproject.entity.Student;
import com.example.studentproject.repository.StudentRepository;
import com.example.studentproject.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
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

            return studentRepository.save(existingStudent);
        }

        return null;
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
