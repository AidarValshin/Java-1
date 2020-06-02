package ru.mephi.java.part2.task10;
//In the RandomNumbers class, provide two static methods randomElement that
//get a random element from an array or array list of integers. (Return zero if the array
//or array list is empty.) Why couldn’t you make these methods into instance methods
//of int[] or ArrayList<Integer>?

import java.util.ArrayList;
import java.util.List;

import static ru.mephi.java.part2.task10.RandomNumbers.randomElement;

public class Program {
    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>();
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
