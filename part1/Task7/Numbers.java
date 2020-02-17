package ru.mephi.java.part1.Task7;

import java.util.Scanner;

import static java.lang.Math.floorMod;

public class Numbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me 2 integers 0-65535");
        Short s1 = (short)in.nextInt();//если ставить nextShort() будет давать ошибку при выходе за границы short
        Short s2 = (short)in.nextInt();
        System.out.println("sum: " +(s1+s2));
        System.out.println("diff: " +(s1-s2));
        System.out.println("multiply: " +(s1*s2));
        System.out.println("divide: " +(s1/s2));
        System.out.println("remainder: " +floorMod(s1, s2));
    }
}
