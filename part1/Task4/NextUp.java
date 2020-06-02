package ru.mephi.java.part1.task4;

import static java.lang.Math.nextUp;

//Write a program that prints the smallest and largest positive double value. Hint:
//Look up Math.nextUp in the Java API.
public class NextUp {
    public static void main(String[] args) {
        System.out.println(nextUp(0.0));
        System.out.println(nextUp(Double.MAX_VALUE));

    }
}
