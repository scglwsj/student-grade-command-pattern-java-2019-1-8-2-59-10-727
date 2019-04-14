package com.tw.router;

import com.tw.application.service.StudentApplicationService;
import com.tw.domain.transcripts.Transcript;
import com.tw.router.viewObject.SearchScoreRequest;
import com.tw.router.viewObject.SearchScoreResponse;

import javax.inject.Inject;

public class ScoreRouter {

    private StudentApplicationService studentApplicationService;

    @Inject
    public ScoreRouter(StudentApplicationService studentApplicationService) {
        this.studentApplicationService = studentApplicationService;
    }

    public SearchScoreResponse search(String in) {
        SearchScoreRequest request = new SearchScoreRequest(in);
        Transcript transcript = studentApplicationService.searchTranscripts(request.getIds());
        return new SearchScoreResponse(transcript);
    }
}
