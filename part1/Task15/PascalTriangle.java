package ru.mephi.java.part1.task15;

import java.util.ArrayList;
import java.util.Scanner;

//Write a program that stores Pascal’s triangle up to a given n in an
//ArrayList<ArrayList<Integer>>.
public class PascalTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me number n");
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        if (in.hasNextInt()) {
            int n = in.nextInt(10);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> arr1 = new ArrayList<>();
                arr1.add(0, 1);
                for (int j = 1; j < i; j++) {
                    arr1.add(j, (arr.get(i - 1)).get(j - 1) + (arr.get(i - 1)).get(j));
                }
                if (i != 0) {
                    arr1.add(i, 1);
                }
                arr.add(i, arr1);
            }
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
            }
        }
    }
}

