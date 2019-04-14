package com.tw.router.viewObject;

import com.tw.domain.students.Student;
import com.tw.domain.students.StudentId;

import java.util.Map;

public class CreateStudentRequest {
    private String id;
    private String name;
    private Map<String, Integer> scores;

    public CreateStudentRequest(String id, String name, Map<String, Integer> scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
    }

    public Student getStudentModel() {
        return new Student(new StudentId(id), name);
    }

    public Map<String, Integer> getScores() {
        return scores;
    }
}
