package com.example.punks;

public class SlovaList {

    private String option1, option2;
    private String UserSelectedAnswer;

    public SlovaList(String option1, String option2, String userSelectedAnswer) {
        this.option1 = option1;
        this.option2 = option2;
        UserSelectedAnswer = userSelectedAnswer;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getUserSelectedAnswer() {
        return UserSelectedAnswer;
    }


}
