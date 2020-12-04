package main.ru.mephi.java.part7.task6;

import java.util.*;

public class Interfaces {
    public static void main(String[] args) {
        Map<String, Set<Integer>> map=new TreeMap<>();
        Set<Integer> set1=new HashSet<>();
        set1.add(1);
        set1.add(2);
        Set<Integer> set2=new HashSet<>();
        set2.add(3);
        set2.add(4);
        map.put("first",set1);
        map.put("second",set2);
        map.get("first").forEach(System.out::println);
        System.out.println();
        map.get("second").forEach(System.out::println);
        System.out.println();
    }
}
