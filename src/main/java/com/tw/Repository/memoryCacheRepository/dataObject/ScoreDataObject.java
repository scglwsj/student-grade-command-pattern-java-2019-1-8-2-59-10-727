package com.tw.repository.memoryCacheRepository.dataObject;

public class ScoreDataObject {
    private String studentId;
    private String Lesson;
    private Integer Score;

    public ScoreDataObject(String studentId, String lesson, Integer score) {
        this.studentId = studentId;
        Lesson = lesson;
        Score = score;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getLesson() {
        return Lesson;
    }

    public Integer getScore() {
        return Score;
    }
}
