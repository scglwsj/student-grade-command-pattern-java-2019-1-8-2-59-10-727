package com.tw.domain.interfaces;

import com.tw.domain.entities.PersonalTranscript;

import java.util.List;

public interface ScoreRepository {
    void create(String studentID, String lesson,Integer score);
    List<PersonalTranscript> search(List<String> ids);
}
