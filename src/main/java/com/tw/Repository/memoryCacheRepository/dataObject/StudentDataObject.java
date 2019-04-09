package com.tw.repository.memoryCacheRepository.dataObject;

import com.tw.domain.entities.Student;

public class StudentDataObject {
    private String id;
    private String name;

    public StudentDataObject(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentDataObject(Student student) {
        id = student.getId();
        name = student.getName();
    }

    public String getId() {
        return id;
    }

    public Student ToEntity() {
        return new Student(id, name);
    }
}
