package com.tw.repository.memoryCacheRepository.dataObject;

import com.tw.domain.students.Student;
import com.tw.domain.students.StudentId;

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
        return new Student(new StudentId(id), name);
    }
}
