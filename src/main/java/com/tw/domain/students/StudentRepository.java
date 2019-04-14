package com.tw.domain.students;

public interface StudentRepository {
    void create(Student student);
    Student findById(String id);
}
