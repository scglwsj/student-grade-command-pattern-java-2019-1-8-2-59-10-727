package com.tw.router.viewObject;

import com.tw.domain.students.StudentId;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchScoreRequest {
    private List<String> ids;

    public SearchScoreRequest(String in) {
        String[] strings = in.replaceAll(" ", "").split(",");
        ids = Arrays.asList(strings);
    }

    public List<StudentId> getStudentIds() {
        return ids.stream().map(StudentId::new).collect(Collectors.toList());
    }
}
