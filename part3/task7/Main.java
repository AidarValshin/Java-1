package ru.mephi.java.part3.task7;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    static class Sortbyname implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(b);
        ar.add(a);
        ar.add(c);
        Lucky.luckySort(ar, new Sortbyname());
        System.out.println(ar);
    }
}
