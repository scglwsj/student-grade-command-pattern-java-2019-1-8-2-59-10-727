package com.tw.application.service;

import com.tw.domain.entities.Transcript;
import com.tw.domain.services.ScoreService;

import javax.inject.Inject;
import java.util.List;

public class ScoreApplicationService {
    private ScoreService scoreService;

    @Inject
    public ScoreApplicationService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public Transcript search(List<String> ids) {
        return scoreService.search(ids);
    }
}
