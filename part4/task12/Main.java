package ru.mephi.java.part4.task12;

import ru.mephi.java.part4.task5.Point;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Point p = new Point(3, 4);
        double x0 = 0;
        long start0 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            x0 += (p.getX());
        }
        long finish0 = System.nanoTime();
        long timeElapsed0 = finish0 - start0;
        System.out.println(" call :   " + timeElapsed0);
        System.out.println(x0);
        double x1 = 0;
        Method m = p.getClass().getDeclaredMethod("getX", null);
        long start1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            x1 -= ((double) m.invoke(p, null));
        }
        long finish1 = System.nanoTime();
        long timeElapsed1 = finish1 - start1;
        System.out.println(" invoke : " + timeElapsed1);
        System.out.println(x1);


        start0 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            x0 -= (p.getX());
        }
        finish0 = System.nanoTime();
        timeElapsed0 = finish0 - start0;
        System.out.println(" call :   " + timeElapsed0);
        System.out.println(x0);

        start1 = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            x1 += ((double) m.invoke(p, null));
        }
        finish1 = System.nanoTime();
        timeElapsed1 = finish1 - start1;
        System.out.println(" invoke : " + timeElapsed1);
        System.out.println(x1);


        start0 = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            x0 += (p.getX());
        }
        finish0 = System.nanoTime();
        timeElapsed0 = finish0 - start0;
        System.out.println(" call :   " + timeElapsed0);
        System.out.println(x0);
        start1 = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            x1 -= ((double) p.getClass().getDeclaredMethod("getX", null).invoke(p, null));
        }
        finish1 = System.nanoTime();
        timeElapsed1 = finish1 - start1;
        System.out.println(" invoke : " + timeElapsed1);
        System.out.println(x1);

    }
}

