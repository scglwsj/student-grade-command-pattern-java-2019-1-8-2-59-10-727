package com.tw.domain.entities;

import java.util.HashMap;
import java.util.Map;

public class PersonalTranscript {
    private String studentId;
    private Student student;
    private Map<String, Integer> scores;

    public PersonalTranscript(String studentId) {
        this.studentId=studentId;
        scores=new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudent(Student student) {
        this.student = student;
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
}
