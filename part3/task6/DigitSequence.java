package ru.mephi.java.part3.task6;

import java.util.Iterator;

public class DigitSequence implements Iterator<Integer> {
    private int number;

    public  DigitSequence(int numb) {
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

    public void remove() {     };

}

