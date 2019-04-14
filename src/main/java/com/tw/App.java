package com.tw;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.tw.domain.transcripts.Transcript;
import com.tw.router.viewObject.SearchScoreResponse;
import com.tw.utils.exception.CreateStudentInputException;
import com.tw.router.ScoreRouter;
import com.tw.router.StudentRouter;
import com.tw.utils.IocModule;

import java.util.Scanner;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    private static Scanner sc = new Scanner(System.in);
    private static StudentRouter studentRouter;
    private static ScoreRouter scoreRouter;

    public static void main(String[] args) {
        init();
        entries();
    }

    private static void init() {
        Injector injector = Guice.createInjector(new IocModule());

        studentRouter = injector.getInstance(StudentRouter.class);
        scoreRouter = injector.getInstance(ScoreRouter.class);
    }

    private static void entries() {
        while (true) {
            System.out.println();
            System.out.println("1. 添加学生");
            System.out.println("2. 生成成绩单");
            System.out.println("3. 退出");
            System.out.println("请输入你的选择（1～3）：");
            String in = sc.nextLine();

            switch (in) {
                case "1":
                    System.out.println();
                    System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
                    try {
                        String studentName = studentRouter.create(sc.nextLine());
                        System.out.println("学生" + studentName + "的成绩被添加");
                    } catch (CreateStudentInputException e) {
                        System.out.println();
                        System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
                    }
                    break;
                case "2":
                    System.out.println();
                    System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                    Transcript transcript = scoreRouter.search(sc.nextLine());
                    printTranscript(transcript);
                    break;
                case "3":
                    return;
                default:
                    System.out.println();
                    System.out.println("无效的输入");
                    break;
            }
        }
    }

    private static void printTranscript(Transcript transcript) {
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