package ru.mephi.java.part1.task9;

import java.util.Scanner;

//Section 1.5.3, “String Comparison,” on p. 21 has an example of two strings s and t
//so that s.equals(t) but s != t. Come up with a different example that doesn’t
//use substring).
public class ExCompare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me a string");
        String s0;
        if (in.hasNextLine()) {
            s0 = in.nextLine();
            String s1 = String.copyValueOf(s0.toCharArray());
            ;
            System.out.println("s0==s1: " + (s0 == s1));
            System.out.println("s0.equals(s1): " + (s0.equals(s1)));
        } else
            System.out.println("not a line ");
    }
}
