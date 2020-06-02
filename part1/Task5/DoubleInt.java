package ru.mephi.java.part1.task5;

//What happens when you cast a double to an int that is larger than the largest
//possible int value? Try it out.
public class DoubleInt {
    public static void main(String[] args) {
        double d = 2147483800.0; // max int 2147483647
        System.out.println((int) d);
    }
}
