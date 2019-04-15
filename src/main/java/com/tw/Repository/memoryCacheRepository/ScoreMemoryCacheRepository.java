package com.tw.repository.memoryCacheRepository;

import com.tw.domain.students.StudentId;
import com.tw.domain.transcripts.ScoreRepository;
import com.tw.repository.memoryCacheRepository.dataObject.ScoreDataObject;

import javax.inject.Inject;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreMemoryCacheRepository implements ScoreRepository {
    private MemoryCache memoryCache;

    @Inject
    public ScoreMemoryCacheRepository(MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
    }

    @Override
    public void create(StudentId studentID, String lesson, Integer score) {
        memoryCache.addScore(new ScoreDataObject(studentID.toString(), lesson, score));
    }

    @Override
    public Map<String, Integer> search(StudentId id) {
        return  memoryCache.getScore(id.toString()).stream()
                .collect(Collectors.toMap(
                ScoreDataObject::getLesson, ScoreDataObject::getScore,
                (oldValue, newValue) -> newValue));
    }
}
