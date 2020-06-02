package ru.mephi.java.part1.task2;

import java.util.Scanner;

import static java.lang.Math.floorMod;

//Write a program that reads an integer angle (which may be positive or negative) and
//normalizes it to a value between 0 and 359 degrees. Try it first with the % operator,
//then with floorMod.
public class Angle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me an angle");
        if (in.hasNextInt()) {
            int angle = in.nextInt(10);
            int n = angle % 360;
            System.out.println("a normalized angle = " + (n < 0 ? (360 + n) : n));
            System.out.println("a normalized angle with FloorMod = " + floorMod(n, 360));
        } else {
            System.out.println("not integer ");
        }
    }

}
