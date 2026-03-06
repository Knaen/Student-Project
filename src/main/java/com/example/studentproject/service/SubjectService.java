package com.example.studentproject.service;

import com.example.studentproject.entity.Subject;
import com.example.studentproject.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        return subject.orElse(null);
    }

    public Subject updateSubject(Long id, Subject subject) {
        Subject existingSubject = subjectRepository.findById(id).orElse(null);

        if (existingSubject != null) {
            existingSubject.setSubjectName(subject.getSubjectName());
            existingSubject.setSubjectCode(subject.getSubjectCode());
            existingSubject.setCredit(subject.getCredit());
            existingSubject.setDescription(subject.getDescription());
            existingSubject.setDepartment(subject.getDepartment());
            existingSubject.setSemester(subject.getSemester());
            existingSubject.setTeacherName(subject.getTeacherName());
            existingSubject.setHoursPerWeek(subject.getHoursPerWeek());
            existingSubject.setIsActive(subject.getIsActive());

            return subjectRepository.save(existingSubject);
        }

        return null;
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}