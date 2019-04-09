package com.tw.router;

import com.tw.application.service.ScoreApplicationService;
import com.tw.domain.entities.PersonalTranscript;
import com.tw.router.viewObject.SearchScoreRequest;
import com.tw.domain.entities.Transcript;

import javax.inject.Inject;

public class ScoreRouter {

    private ScoreApplicationService scoreApplicationService;

    @Inject
    public ScoreRouter(ScoreApplicationService scoreApplicationService) {
        this.scoreApplicationService = scoreApplicationService;
    }

    public void search(String in) {
        SearchScoreRequest request = new SearchScoreRequest(in);
        Transcript transcript = scoreApplicationService.search(request.getIds());
        printCount(transcript);
    }

    private void printCount(Transcript transcript) {
        System.out.println();
        System.out.println("成绩单");
        System.out.println("姓名|数学|语文|英语|编程|平均分|总分");
        System.out.println("========================");
        for (PersonalTranscript personalTranscript : transcript.getPersonalTranscripts()) {
            System.out.println(personalTranscript.getStudent().getName() + "|" +
                    personalTranscript.getScores().get("Math") + "|" +
                    personalTranscript.getScores().get("Chinese") + "|" +
                    personalTranscript.getScores().get("English") + "|" +
                    personalTranscript.getScores().get("Program") + "|" +
                    personalTranscript.getAverageScore() + "|" +
                    personalTranscript.getTotalScore());
        }
        System.out.println("========================");
        System.out.println("全班总分平均数：" + String.format("%.1f", transcript.getAverageScore()));
        System.out.println("全班总分中位数：" + transcript.getMedianScore());
    }
}
