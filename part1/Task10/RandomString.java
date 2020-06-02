package ru.mephi.java.part1.task10;
import java.util.Random;
//Write a program that produces a random string of letters and digits by generating a
//random long value and printing it in base 36.
public class RandomString
{
    public  static void main(String[] args) {
        long generatedLong = new Random().nextLong();
        String s36 = Long.toString(generatedLong, 36);
        System.out.println("line: "+ s36);

    }
}
