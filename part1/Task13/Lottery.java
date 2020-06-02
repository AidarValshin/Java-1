package ru.mephi.java.part1.task13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//Write a program that prints a lottery combination, picking six distinct numbers
//between 1 and 49. To pick six distinct numbers, start with an array list filled with 1
//… 49. Pick a random index and remove the element. Repeat six times. Print the
//result in sorted order.
public class Lottery {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 49; i++) {
            arr.add(i);
        }
        List<Integer> a = new ArrayList<>();
        Random rnd = new Random();
        rnd.setSeed(java.lang.System.nanoTime());
        for (int j = 0; j < 6; j++) {
            a.add(arr.remove(rnd.nextInt((49 - j))));
        }
        Collections.sort(a);
        System.out.println(a);
    }
}
