package com.tw.router.viewObject;

import java.util.Arrays;
import java.util.List;

public class SearchScoreRequest {
    private List<String> ids;

    public SearchScoreRequest(String in) {
        String[] strings = in.replaceAll(" ", "").split(",");
        ids = Arrays.asList(strings);
    }

    public List<String> getIds() {
        return ids;
    }
}
