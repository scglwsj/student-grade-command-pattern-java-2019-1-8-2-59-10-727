package com.tw.router.viewObject;

import com.tw.domain.transcripts.Transcript;

import java.util.List;
import java.util.stream.Collectors;

public class SearchScoreResponse {
    private String averageScore;
    private String medianScore;
    private List<String> personalScores;

    public SearchScoreResponse(Transcript transcript) {
        this.averageScore = String.format("%.1f", transcript.getAverageScore());
        this.medianScore = transcript.getMedianScore().toString();
        this.personalScores = transcript.getPersonalTranscripts()
                .stream()
                .map(personalTranscript ->
                        personalTranscript.getStudent().getName()
                                + "|" + personalTranscript.getScores().get("Math")
                                + "|" + personalTranscript.getScores().get("Chinese")
                                + "|" + personalTranscript.getScores().get("English")
                                + "|" + personalTranscript.getScores().get("Program")
                                + "|" + personalTranscript.getAverageScore()
                                + "|" + personalTranscript.getTotalScore()
                ).collect(Collectors.toList());
    }

    public String getAverageScore() {
        return averageScore;
    }

    public String getMedianScore() {
        return medianScore;
    }

    public List<String> getPersonalScores() {
        return personalScores;
    }
}
