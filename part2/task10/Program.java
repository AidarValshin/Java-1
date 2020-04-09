package ru.mephi.java.part2.task10;

import java.util.ArrayList;

import static ru.mephi.java.part2.task10.RandomNumbers.randomElement;

public class Program {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            arr1.add(i);
        }
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(randomElement(arr1));
        System.out.println(randomElement(arr2));
        int[] arr3 = {};
        System.out.println(randomElement(arr3));

    }
}
