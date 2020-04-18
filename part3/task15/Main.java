package ru.mephi.java.part3.task15;

import ru.mephi.java.part3.task4.IntSequence;

import static ru.mephi.java.part3.task15.IntSequenceRandom.randomInts;

public class Main {
    public static void main(String[] args) {
        IntSequence random = randomInts(2, 40);
        for (int i = 0; i <= 10; i++) {
            System.out.println(random.next());
        }
    }
}
