package com.example.studentproject.controller;

import com.example.studentproject.entity.Subject;
import com.example.studentproject.service.StudentService;
import com.example.studentproject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("getAllSubjects")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("getSubject")
    public Subject getSubjectById(@RequestParam Long id) {
        return subjectService.getSubjectById(id);
    }

    @PutMapping
    public Subject updateSubject(Long id, Subject subject) {
        return subjectService.updateSubject(id,subject);
    }

    @DeleteMapping
    public void deleteSubject(Long id) {
       subjectService.deleteSubject(id);
    }
}
