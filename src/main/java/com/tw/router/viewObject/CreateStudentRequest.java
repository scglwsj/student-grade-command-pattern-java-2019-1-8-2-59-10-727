package com.tw.router.viewObject;

import com.tw.domain.entities.Student;
import com.tw.utils.Constant;
import com.tw.utils.exception.CreateStudentInputException;

import java.util.HashMap;
import java.util.Map;

public class CreateStudentRequest {
    private String id;
    private String name;
    private Map<String, Integer> scores;

    public CreateStudentRequest(String in) throws CreateStudentInputException {
        String[] strings = in.replaceAll(" ", "").split(",");
        if (strings.length != Constant.CREATE_STUDENT_INPUT_PARAMETER_NUMBER) {
            throw new CreateStudentInputException();
        }

        name = strings[0];
        id = strings[1];

        scores = new HashMap<>();
        for (int i = 2; i < strings.length; i++) {
            String[] lessenAndScore = strings[i].split(":");
            if (lessenAndScore.length != Constant.CREATE_SCORE_INPUT_PARAMETER_NUMBER ||
                    !Constant.LESS_NAME_CHINESE_TO_ENGLISH_MAP.containsKey(lessenAndScore[0]) ||
                    !lessenAndScore[1].matches("\\d+")) {
                throw new CreateStudentInputException();
            }

            scores.put(Constant.LESS_NAME_CHINESE_TO_ENGLISH_MAP.get(lessenAndScore[0]), Integer.parseInt(lessenAndScore[1]));
        }

        if (scores.size() != 4) {
            throw new CreateStudentInputException();
        }
    }

    public Student getStudentModel() {
        return new Student(id, name);
    }

    public Map<String, Integer> getScores() {
        return scores;
    }
}
