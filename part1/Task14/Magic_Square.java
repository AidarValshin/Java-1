package ru.mephi.java.part1.task14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Write a program that reads a two-dimensional array of integers and determines
//whether it is a magic square (that is, whether the sum of all rows, all columns, and
//the diagonals is the same). Accept lines of input that you break up into individual
//integers, and stop when the user enters a blank line.
public class Magic_Square {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me lines");
        List<List<Integer>> arr = new ArrayList<>();
        String line;
        while (!(line = in.nextLine()).isEmpty()) {
            String[] result = line.split("\\s+");
            ArrayList<Integer> arrI = new ArrayList<>();
            for (String s : result) {
                arrI.add(Integer.parseInt(s));
            }
            arr.add(arrI);
        }
        boolean flag = true;
        int length = arr.size();
        int[] col = new int[length];
        int diag1 = 0;
        int lin = 0;
        int diag2 = 0;
        int lin1;
        for (int i = 0; i < length; i++) //loop of rows
        {
            List<Integer> arrI = arr.get(i);
            lin1 = 0;
            for (int j = 0; j < length; j++) //loop of number in  row
            {
                if (i == 0) {
                    lin += arrI.get(j); //rows
                } else {
                    lin1 += arrI.get(j); //rows
                }
                col[j] += arrI.get(j); // columns
                if (i == j) {
                    diag1 += arrI.get(j);
                }
                if (i == (length - 1 - j)) {
                    diag2 += arrI.get(j);
                }
            }
            // checks 
            if (lin != lin1 && i != 0) //rows
            {
                flag = false;
                break;
            }
        }
        int col0 = col[0];
        for (int k = 1; k < length; k++) // columns
            if (col0 != col[k]) {
                flag = false;
                break;
            }
        if (diag1 != diag2) {
            flag = false;
        }
        if (diag1 != col0 || col0 != lin) {
            flag = false;
        }
        System.out.println(flag);
    }
}
