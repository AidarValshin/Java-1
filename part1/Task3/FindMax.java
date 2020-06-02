package ru.mephi.java.part1.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Using only the conditional operator, write a program that reads three integers and
//prints the largest. Repeat with Math.max.
public class FindMax {
    public static void main(String[] args) {
        work(input());
    }

    // input numbers
    public static List<Integer> input() {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me  numbers");
        List<Integer> arr = new ArrayList<>();
        int i = 0;
        while (in.hasNextInt() && i < 3) {
            arr.add(in.nextInt());
            i++;
        }
        return arr;
    }

    //find the the largest
    public static void work(List<Integer> arr) {
        int a1 = Integer.MIN_VALUE;
        int a2;
        int b;
        for (int i = 0; i < arr.size(); i++) {
            b = arr.get(i);
            if (a1 < b) {
                a1 = b;
            }
        }
        a2 = Collections.max(arr);
        System.out.println("max integer 1 = " + a1);
        System.out.println("max integer 2 = " + a2);
    }
}

