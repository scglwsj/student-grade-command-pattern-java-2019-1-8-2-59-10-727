package com.tw.domain.transcripts;

import com.tw.domain.students.Student;

import java.util.Map;

public class PersonalTranscript {
    private Student student;
    private Map<String, Integer> scores;

    PersonalTranscript(Student student, Map<String, Integer> scores) {
        this.student = student;
        this.scores = scores;
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
