package ru.mephi.java.part1.task8;

import java.util.Scanner;

//Write a program that reads a string and prints all of its nonempty substrings.
public class SubStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me a string");
        String s;
        if (in.hasNextLine()) {
            s = in.nextLine();
            for (int j = 0; j < s.length(); j++) {
                for (int i = (j + 1); i <= s.length(); i++) {
                    System.out.println(s.substring(j, i));
                }
            }
        } else {
            System.out.println("not a line ");
        }
    }
}
