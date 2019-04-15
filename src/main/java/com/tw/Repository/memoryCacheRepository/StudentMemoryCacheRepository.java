package com.tw.repository.memoryCacheRepository;

import com.tw.domain.students.Student;
import com.tw.domain.students.StudentId;
import com.tw.domain.students.StudentRepository;
import com.tw.repository.memoryCacheRepository.dataObject.StudentDataObject;

import javax.inject.Inject;

public class StudentMemoryCacheRepository implements StudentRepository {
    private MemoryCache memoryCache;

    @Inject
    public StudentMemoryCacheRepository(MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
    }

    @Override
    public void create(Student student) {
        memoryCache.addStudent(new StudentDataObject(student));
    }

    @Override
    public Student findById(StudentId id) {
        return memoryCache.getStudent(id.toString()).toEntity();
    }
}
