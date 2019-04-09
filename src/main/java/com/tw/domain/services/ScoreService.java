package com.tw.domain.services;

import com.tw.domain.entities.PersonalTranscript;
import com.tw.domain.interfaces.ScoreRepository;
import com.tw.domain.entities.Transcript;
import com.tw.domain.interfaces.StudentRepository;

import javax.inject.Inject;
import java.util.List;

public class ScoreService {
    private ScoreRepository scoreRepository;
    private StudentRepository studentRepository;

    @Inject
    public ScoreService(ScoreRepository scoreRepository, StudentRepository studentRepository) {
        this.scoreRepository = scoreRepository;
        this.studentRepository = studentRepository;
    }

    public Transcript search(List<String> ids) {
        List<PersonalTranscript> personalTranscripts = scoreRepository.search(ids);
        for (PersonalTranscript personalTranscript : personalTranscripts) {
            personalTranscript.setStudent(studentRepository.findById(personalTranscript.getStudentId()));
        }
        return new Transcript(personalTranscripts);
    }
}
