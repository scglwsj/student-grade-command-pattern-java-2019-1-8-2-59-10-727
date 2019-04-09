package com.tw.repository.memoryCacheRepository;

import com.tw.domain.entities.PersonalTranscript;
import com.tw.domain.interfaces.ScoreRepository;
import com.tw.repository.memoryCacheRepository.dataObject.ScoreDataObject;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ScoreMemoryCacheRepository implements ScoreRepository {
    private MemoryCache memoryCache;

    @Inject
    public ScoreMemoryCacheRepository(MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
    }

    @Override
    public void create(String studentID, String lesson,Integer score) {
        memoryCache.addScore(new ScoreDataObject(studentID, lesson, score));
    }

    @Override
    public List<PersonalTranscript> search(List<String> ids) {
        ArrayList<PersonalTranscript> personalTranscripts = new ArrayList<>();

        memoryCache.getScores(ids).forEach(scoreDataObject -> {
            PersonalTranscript personalTranscript = personalTranscripts
                    .stream()
                    .filter(pt ->
                            pt.getStudentId().equals(scoreDataObject.getStudentId()))
                    .findFirst()
                    .orElseGet(() -> {
                        PersonalTranscript pt = new PersonalTranscript(scoreDataObject.getStudentId());
                        personalTranscripts.add(pt);
                        return pt;
                    });
            personalTranscript.getScores().put(scoreDataObject.getLesson(),scoreDataObject.getScore());
        });

        return personalTranscripts;
    }
}
