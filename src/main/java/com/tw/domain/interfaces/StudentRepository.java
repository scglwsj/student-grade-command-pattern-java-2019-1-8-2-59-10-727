package com.tw.domain.interfaces;

import com.tw.domain.entities.Student;

public interface StudentRepository {
    void create(Student student);

    Student findById(String id);
}
