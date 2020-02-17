package ru.mephi.java.part1.AddTask;

import java.util.Arrays;

public class ArrAdd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] arr1 = add(arr, 1);
        System.out.println(Arrays.toString(arr1));
    }

    public static int[] add(int[] arr, int a) {
        int len = arr.length;
        int[] arr1 = Arrays.copyOf(arr, (len + 1));
        arr1[len] = a;
        return arr1;
    }
}
