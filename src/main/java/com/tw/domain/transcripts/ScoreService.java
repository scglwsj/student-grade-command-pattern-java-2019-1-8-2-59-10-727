package com.tw.domain.transcripts;

import com.tw.domain.students.StudentRepository;

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
        personalTranscripts.forEach(personalTranscript ->
                personalTranscript.updateStudent(studentRepository.findById(personalTranscript.getStudentId())));
        return new Transcript(personalTranscripts);
    }
}
