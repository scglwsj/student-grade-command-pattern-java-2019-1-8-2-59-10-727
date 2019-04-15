package com.tw.domain.transcripts;

import com.tw.domain.students.StudentId;

import java.util.Map;

public interface ScoreRepository {
    void create(StudentId studentID, String lesson, Integer score);

    Map<String, Integer> search(StudentId studentId);
}
