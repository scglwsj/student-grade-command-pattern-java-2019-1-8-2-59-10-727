package com.tw.utils;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    public static final int CREATE_STUDENT_INPUT_PARAMETER_NUMBER = 6;
    public static final int CREATE_SCORE_INPUT_PARAMETER_NUMBER = 2;
    public static final Map<String, String> LESS_NAME_CHINESE_TO_ENGLISH_MAP = new HashMap<>();

    static {
        LESS_NAME_CHINESE_TO_ENGLISH_MAP.put("语文", "Chinese");
        LESS_NAME_CHINESE_TO_ENGLISH_MAP.put("数学", "Math");
        LESS_NAME_CHINESE_TO_ENGLISH_MAP.put("英语", "English");
        LESS_NAME_CHINESE_TO_ENGLISH_MAP.put("编程", "Program");
    }
}
