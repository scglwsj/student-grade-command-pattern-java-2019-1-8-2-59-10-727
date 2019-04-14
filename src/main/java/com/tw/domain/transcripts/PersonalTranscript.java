package com.tw.domain.transcripts;

import com.tw.domain.students.Student;
import com.tw.domain.students.StudentId;

import java.util.HashMap;
import java.util.Map;

public class PersonalTranscript {
    private Student student;
    private Map<String, Integer> scores;

    public PersonalTranscript(String studentId) {
        this.student = new Student(new StudentId(studentId));
        scores = new HashMap<>();
    }

    public String getStudentId() {
        return student.getId();
    }

    public Double getAverageScore() {
        return scores.values().stream().mapToDouble(value -> value).average().orElse(0);
    }

    public Student getStudent() {
        return student;
    }

    public Integer getTotalScore() {
        return scores.values().stream().mapToInt(value -> value).sum();
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    void updateStudent(Student student) {
        this.student = student;
    }

}
