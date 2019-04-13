package com.tw.repository.memoryCacheRepository.dataObject;

import com.tw.domain.students.Student;

public class StudentDataObject {
    private String id;
    private String name;

    public StudentDataObject(Student student) {
        id = student.getId();
        name = student.getName();
    }

    public String getId() {
        return id;
    }

    public Student toEntity() {
        return new Student(id, name);
    }
}
