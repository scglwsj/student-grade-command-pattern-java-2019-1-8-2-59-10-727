package com.tw.domain.entities;

import java.util.List;
import java.util.stream.Collectors;

public class Transcript {
    private List<PersonalTranscript> personalTranscripts;


    public Transcript(List<PersonalTranscript> personalTranscripts) {
        this.personalTranscripts = personalTranscripts;
    }

    public List<PersonalTranscript> getPersonalTranscripts() {
        return personalTranscripts;
    }

    public Double getMedianScore() {
        List<Integer> integerList = personalTranscripts.stream().map(PersonalTranscript::getTotalScore).sorted().collect(Collectors.toList());
        if (integerList.size() % 2 == 0) {
            return (double) (integerList.get(integerList.size() / 2 - 1) + integerList.get(integerList.size() / 2)) / (double) 2;
        } else {
            return integerList.get(integerList.size() / 2).doubleValue();
        }
    }

    public Double getAverageScore() {
        return personalTranscripts.stream().mapToDouble(PersonalTranscript::getTotalScore).average().orElse(0);
    }
}
