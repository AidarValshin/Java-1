package ru.mephi.java.part4.task12;

import ru.mephi.java.part4.task5.Point;

import java.lang.reflect.InvocationTargetException;

import java.time.Duration;
import java.time.Instant;


public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        Point p=new Point(3,4);
       Instant start0 = Instant.now(); // через System NanoTime
       for (int i = 0; i < 1000000; i++) {
          p.toString();
        }
        Instant finish0 = Instant.now();
        long timeElapsed0 = Duration.between(start0, finish0).toMillis();
        System.out.println(" call : " + timeElapsed0);

        Instant start1 = Instant.now();
        for (int i = 0; i < 1000000; i++) {
            p.getClass().getDeclaredMethod("toString",null).invoke(p,null);
        }
        Instant finish1 = Instant.now();
        long timeElapsed1 = Duration.between(start1, finish1).toMillis();
        System.out.println(" invoke : " + timeElapsed1);


    }
}

