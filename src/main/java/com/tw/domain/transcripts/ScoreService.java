package com.tw.domain.transcripts;

import com.tw.domain.students.Student;
import com.tw.domain.students.StudentId;
import com.tw.domain.students.StudentRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreService {
    private ScoreRepository scoreRepository;
    private StudentRepository studentRepository;

    @Inject
    public ScoreService(ScoreRepository scoreRepository, StudentRepository studentRepository) {
        this.scoreRepository = scoreRepository;
        this.studentRepository = studentRepository;
    }

    public Transcript search(List<StudentId> studentIds) {
        List<PersonalTranscript> personalTranscripts = studentIds.stream().map(studentId -> {
            Map<String, Integer> score = scoreRepository.search(studentId);
            Student student = studentRepository.findById(studentId);
            return new PersonalTranscript(student, score);
        }).collect(Collectors.toList());

        return new Transcript(personalTranscripts);
    }
}
