package com.tw.application.service;

import com.tw.domain.students.Student;
import com.tw.domain.transcripts.Transcript;
import com.tw.domain.transcripts.ScoreService;
import com.tw.domain.students.StudentService;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class StudentApplicationService {
    private ScoreService scoreService;
    private StudentService studentService;

    @Inject
    public StudentApplicationService(ScoreService scoreService, StudentService studentService) {
        this.scoreService = scoreService;
        this.studentService = studentService;
    }

    public void createStudent(Student student, Map<String, Integer> scoreList) {
        studentService.create(student, scoreList);
    }

    public Transcript searchTranscripts(List<String> ids) {
        return scoreService.search(ids);
    }
}
