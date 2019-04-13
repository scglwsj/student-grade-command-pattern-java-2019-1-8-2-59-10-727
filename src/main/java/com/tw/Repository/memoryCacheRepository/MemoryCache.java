package com.tw.repository.memoryCacheRepository;

import com.tw.repository.memoryCacheRepository.dataObject.ScoreDataObject;
import com.tw.repository.memoryCacheRepository.dataObject.StudentDataObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryCache {
    static private List<StudentDataObject> studentDataObjects;
    static private List<ScoreDataObject> scoreDataObjects;

    public MemoryCache() {
        studentDataObjects = new ArrayList<>();
        scoreDataObjects = new ArrayList<>();
    }

    void addStudent(StudentDataObject studentDataObject) {
        studentDataObjects.add(studentDataObject);
    }

    void addScore(ScoreDataObject scoreDataObject) {
        scoreDataObjects.add(scoreDataObject);
    }

    StudentDataObject getStudent(String id) {
        return studentDataObjects.stream().filter(studentDataObject -> studentDataObject.getId().equals(id)).findFirst().orElseGet(null);
    }

    List<ScoreDataObject> getScores(List<String> ids) {
        return scoreDataObjects.stream().filter(scoreDataObject ->
                ids.contains(scoreDataObject.getStudentId())).collect(Collectors.toList());
    }
}
