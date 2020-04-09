package ru.mephi.java.part3.task6;
import ru.mephi.java.part3.task6.DigitSequence.*;
public class Main {
    public static void main(String[] args) {
        DigitSequence seq = new DigitSequence(123632);
        seq.print();
        seq.remove();
        System.out.println("          ");
        DigitSequence seq1 = new DigitSequence(1236345);
        seq1.forEachRemaining(System.out::println);

    }
}

