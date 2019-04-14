package com.tw.domain.students;

public class Student {
    private StudentId id;
    private String name;

    public Student(StudentId id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(StudentId id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }

    public String getName() {
        return name;
    }
}
