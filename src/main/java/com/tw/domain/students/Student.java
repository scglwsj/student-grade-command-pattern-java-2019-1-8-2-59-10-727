package com.tw.domain.students;

public class Student {
    private StudentId id;
    private String name;

    public Student(StudentId id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentId getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
