package main.ru.mephi.java.part8.task15;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class PrimeNumber {
   public static Stream<BigInteger> primeNumbers(){
       BigInteger bigInteger = BigInteger.valueOf(100000);//10**5
       BigInteger bigInteger1 = bigInteger.pow(10);
     return   Stream.iterate(bigInteger1,i->i.add(BigInteger.ONE))
               .parallel().filter(i->i.isProbablePrime(100))
               .limit(500);
   }

    public static void main(String[] args) {
     //   primeNumbers().forEach(System.out::println);
        System.out.println(primeNumbers().count());
    }
}
