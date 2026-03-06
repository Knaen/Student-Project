package com.example.studentproject.controller;

import com.example.studentproject.entity.Student;
import com.example.studentproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("getStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping
    public Student getStudentById(@RequestParam Long id){
        return studentService.getStudentById(id);
    }
    @PutMapping
    public Student updateStudent(Long id, Student student){
        Student updateStudent=studentService.updateStudent(id,student);
        return updateStudent;
    }
    @DeleteMapping
    public void deleteStudent(Long id){
        studentService.deleteStudent(id);
    }
}
