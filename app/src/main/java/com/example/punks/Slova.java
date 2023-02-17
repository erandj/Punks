package com.example.punks;

import java.util.ArrayList;
import java.util.List;

public class Slova  {




    private static List<Slova> firstSlovo () {
        final List<Slova> questionsList = new ArrayList<>();
        final Slova question1 = new Slova(R.string.slovo1)
    }




    public static List<Slova> getQuest (String selectedTopicName) {
        switch (selectedTopicName) {
            case "verno" : return firstSlovo();
            case "neverno" : return secondSlovo();
            default: return ugledarQuest();
        }
    }


}
