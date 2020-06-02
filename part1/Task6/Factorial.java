package ru.mephi.java.part1.task6;

import java.math.BigInteger;

//Write a program that computes the factorial n! = 1 × 2 × … × n, using
//BigInteger. Compute the factorial of 1000.
public class Factorial {
    public static void main(String[] args) {
        BigInteger f = BigInteger.valueOf(1);
        for (int i = 1; i <= 1000; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        System.out.println(f);
    }
}
