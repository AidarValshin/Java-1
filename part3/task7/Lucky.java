package ru.mephi.java.part3.task7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Lucky {
    static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        String first = null;
        String second = null;
        boolean fl = true;
        while (fl == true) {
            fl = false;
            for (int i = 0; i < strings.size(); i++) {
                first = strings.get(i);
                if (strings.size() > i + 1) {
                    second = strings.get(i + 1); //Change here
                }
                if (comp.compare(first, second) > 0) {
                    fl = true;
                    break;
                }
            }
            if (fl == true) {
                Collections.shuffle(strings);
            }
        }
    }
}
