package ru.mephi.java.part2.task10;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {
    public static int randomElement(ArrayList<Integer> arr) {
        Random r = new Random();
        int len = arr.size();
        if (len == 0) {
            return 0;
        } else {
            return arr.get(r.nextInt(len));
        }
    }

    public static int randomElement(int[] arr) {
        Random r = new Random();
        int len = arr.length;
        if (len == 0) {
            return 0;
        } else {
            return arr[(r.nextInt(len))];
        }
    }
}
