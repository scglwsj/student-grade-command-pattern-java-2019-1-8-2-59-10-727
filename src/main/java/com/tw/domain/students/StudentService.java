package com.tw.domain.students;


import com.tw.domain.transcripts.ScoreRepository;

import javax.inject.Inject;
import java.util.Map;

public class StudentService {
    private ScoreRepository scoreRepository;
    private StudentRepository studentRepository;

    @Inject
    public StudentService(ScoreRepository scoreRepository, StudentRepository studentRepository) {
        this.scoreRepository = scoreRepository;
        this.studentRepository = studentRepository;
    }

    public void create(Student student, Map<String, Integer> scoreList) {
        studentRepository.create(student);
        scoreList.forEach((lesson, score) -> scoreRepository.create(student.getId(), lesson, score));
    }
}
