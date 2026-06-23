package com.example.studentproject.service;

import com.example.studentproject.entity.Student;
import com.example.studentproject.entity.Subject;
import com.example.studentproject.exception.CustomException;
import com.example.studentproject.repository.StudentRepository;
import com.example.studentproject.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

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

    public void enrollSubject(Long studentId, Long subjectId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new CustomException("Tələbə tapılmadı"));

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new CustomException("Fənn tapılmadı"));

        if (!subject.getIsActive()) {
            throw new CustomException("Bu fənn hazırda aktiv deyil!");
        }

        // Sənin yazdığın metodu burada çağırırıq:
        // Optional-ın içi boşdursa, yeni ArrayList yaradırıq ki, xəta (NPE) verməsin
        List<Subject> studentSubjects = student.getSubjects().orElseGet(ArrayList::new);

        // 1. Biznes Yoxlaması: Kredit limiti aşılırımı?
        int currentTotalCredits = studentSubjects.stream()
                .mapToInt(Subject::getCredit)
                .sum();

        if (currentTotalCredits + subject.getCredit() > 30) {
            throw new CustomException("Maksimum semestr kredit limitini (30) aşırsınız!");
        }

        // 2. Biznes Yoxlaması: Tələbə bu fənni artıq götürübmü?
        boolean alreadyEnrolled = studentSubjects.stream()
                .anyMatch(s -> s.getId().equals(subjectId));

        if (alreadyEnrolled) {
            throw new CustomException("Tələbə bu fənnə artıq qeydiyyatdan keçib!");
        }

        // Hər şey qaydasındadırsa fənni siyahıya əlavə edirik
        studentSubjects.add(subject);

        // Əgər Student entity-sində subjects field-i null idisə, yeni siyahını set edirik
        student.setSubjects(studentSubjects);

        studentRepository.save(student);
    }
}