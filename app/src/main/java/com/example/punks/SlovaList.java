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

    final int[] yktslovo = {
            R.string.slovo1,
            R.string.slovo2,
            R.string.slovo3,
            R.string.slovo4,
            R.string.slovo5,
            R.string.slovo6,
            R.string.slovo7,
            R.string.slovo8,
            R.string.slovo9,
            R.string.slovo10,
            R.string.slovo11,

    };

    final int[] russlovo = {
            R.string.russlovo1,
            R.string.russlovo2,
            R.string.russlovo3,
            R.string.russlovo4,
            R.string.russlovo5,
            R.string.russlovo6,
            R.string.russlovo7,
            R.string.russlovo8,
            R.string.russlovo9,
            R.string.russlovo10,
            R.string.russlovo11,


    };
}
