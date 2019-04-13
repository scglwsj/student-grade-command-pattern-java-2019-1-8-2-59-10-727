package com.tw.router;

import com.tw.application.service.StudentApplicationService;
import com.tw.router.viewObject.CreateStudentRequest;
import com.tw.utils.Constant;
import com.tw.utils.exception.CreateStudentInputException;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRouter {
    private StudentApplicationService studentApplicationService;

    @Inject
    public StudentRouter(StudentApplicationService studentApplicationService) {
        this.studentApplicationService = studentApplicationService;
    }

    public String create(String in) throws CreateStudentInputException {
        CreateStudentRequest request = requestConstructor(in);
        studentApplicationService.create(request.getStudentModel(), request.getScores());
        return request.getStudentModel().getName();
    }

    private CreateStudentRequest requestConstructor(String in) throws CreateStudentInputException {
        String[] strings = in.replaceAll(" ", "").split(",");
        if (strings.length != Constant.CREATE_STUDENT_INPUT_PARAMETER_NUMBER) {
            throw new CreateStudentInputException();
        }

        String name = strings[0];
        String id = strings[1];

        Map<String, Integer> scores = Arrays.stream(strings)
                .map(string -> string.split(":"))
                .filter(lessenAndScore ->
                        lessenAndScore.length == Constant.CREATE_SCORE_INPUT_PARAMETER_NUMBER
                                && Constant.LESS_NAME_CHINESE_TO_ENGLISH_MAP.containsKey(lessenAndScore[0])
                                && lessenAndScore[1].matches("\\d+"))
                .collect(Collectors.toMap(
                        lessenAndScore -> Constant.LESS_NAME_CHINESE_TO_ENGLISH_MAP.get(lessenAndScore[0]),
                        lessenAndScore -> Integer.parseInt(lessenAndScore[1]),
                        (oldValue, newValue) -> newValue));

        if (scores.size() != 4) {
            throw new CreateStudentInputException();
        }

        return new CreateStudentRequest(id, name, scores);
    }
}
