package com.tw.application.service;

import com.tw.domain.entities.Student;
import com.tw.domain.services.StudentService;

import javax.inject.Inject;
import java.util.Map;

public class StudentApplicationService {
    private StudentService studentService;

    @Inject
    public StudentApplicationService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void create(Student student, Map<String, Integer> scoreList) {
        studentService.create(student, scoreList);
    }
}
