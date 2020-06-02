package ru.mephi.java.part1.task1;

import java.util.Scanner;

//Write a program that reads an integer and prints it in binary, octal, and hexadecimal.
//Print the reciprocal as a hexadecimal floating-point number.
public class Numbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me number");
        if (in.hasNextInt()) {
            int number = in.nextInt(10);
            String s2 = Integer.toString(number, 2); //binary
            String s8 = Integer.toString(number, 8);//octal
            String s16 = Integer.toString(number, 16);//hexadecimal
            System.out.println("2: " + s2 + '\n' + "8: " + s8 + '\n' + "16: " + s16);
            if (number != 0) {
                double reciprocal = 1 / ((double) number);
                String rec16 = Double.toHexString(reciprocal); //reciprocal
                System.out.println("reciprocal 16: " + rec16);
            }
        } else {
            System.out.println("not integer ");
        }
    }
}
