package ru.mephi.java.part1.Task6;
import    java.math.BigInteger;
public class Factorial {
    public  static void main(String[] args)
    {
        BigInteger f = BigInteger.valueOf(1);
        for( int i =1; i<=1000;i++)
        {
            f=f.multiply(BigInteger.valueOf(i));
        }
        System.out.println(f);
    }
}
