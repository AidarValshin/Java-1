package main.ru.mephi.java.part5.task10;

import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(int n) {
        try {
            if (n < 0) {
                throw new IllegalArgumentException("N can't be negative");
            }
            if (n == 0 || n == 1) {
                System.out.println(1);
                return BigInteger.ONE;
            }
            BigInteger result = BigInteger.valueOf(n).multiply(factorial(n - 1));
            System.out.println(n);
            return result;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace(System.out);
            //   ex.printStackTrace();
        }
        return BigInteger.valueOf(n);
    }

    public static void main(String[] args) {
        System.out.println(factorial(10));
        System.out.println(factorial(-10));
    }
}
