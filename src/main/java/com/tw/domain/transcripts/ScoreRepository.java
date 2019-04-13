package com.tw.domain.transcripts;

import java.util.List;

public interface ScoreRepository {
    void create(String studentID, String lesson,Integer score);
    List<PersonalTranscript> search(List<String> ids);
}
