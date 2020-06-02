package ru.mephi.java.part3.task6;
//In this exercise, you will try out what happens when a method is added to an
//interface. In Java 7, implement a class DigitSequence that implements
//Iterator<Integer>, not IntSequence. Provide methods hasNext, next,
//and a do-nothing remove. Write a program that prints the elements of an instance.
//In Java 8, the Iterator class gained another method, forEachRemaining.
//Does your code still compile when you switch to Java 8? If you put your Java 7 class
//in a JAR file and don’t recompile, does it work in Java 8? What if you call the
//forEachRemaining method? Also, the remove method has become a default
//method in Java 8, throwing an UnsupportedOperationException. What
//happens when remove is called on an instance of your class?

import java.util.Iterator;

public class DigitSequence implements Iterator<Integer> {
    private int number;

    public DigitSequence(int numb) {
        number = numb;
    }

    @Override
    public boolean hasNext() {
        return number != 0;
    }

    @Override
    public Integer next() {
        int result = number % 10;
        number /= 10;
        return result;
    }

    public void print() {
        while (hasNext()) {
            System.out.println(next());
        }
    }

    public void remove() {
    }
}

