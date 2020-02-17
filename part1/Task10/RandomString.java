package ru.mephi.java.part1.Task10;
import java.util.Random;
public class RandomString
{
    public  static void main(String[] args) {
        long generatedLong = new Random().nextLong();
        String s36 = Long.toString(generatedLong, 36);
        System.out.println("line: "+ s36);

    }
}
