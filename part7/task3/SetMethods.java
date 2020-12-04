package main.ru.mephi.java.part7.task3;

import java.util.HashSet;
import java.util.Set;

public class SetMethods {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set1.addAll(set2);//union
        System.out.println("union");
        set1.forEach(System.out::print);

        System.out.println();
        System.out.println("intersection");
        set1.retainAll(set2);//intersection
        set1.forEach(System.out::print);

        System.out.println();
        System.out.println("difference");
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.removeAll(set2);//difference
        set1.forEach(System.out::print);
    }
}
