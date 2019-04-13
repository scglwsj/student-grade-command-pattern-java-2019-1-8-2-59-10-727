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

    public void search(String in) {
        SearchScoreRequest request = new SearchScoreRequest(in);
        Transcript transcript = studentApplicationService.search(request.getIds());
        printCount(transcript);
    }

    private void printCount(Transcript transcript) {
        SearchScoreResponse searchScoreResponse = new SearchScoreResponse(transcript);

        System.out.println();
        System.out.println("成绩单");
        System.out.println("姓名|数学|语文|英语|编程|平均分|总分");
        System.out.println("========================");
        searchScoreResponse.getPersonalScores().forEach(System.out::println);
        System.out.println("========================");
        System.out.println("全班总分平均数：" + searchScoreResponse.getAverageScore());
        System.out.println("全班总分中位数：" + searchScoreResponse.getMedianScore());
    }
}
