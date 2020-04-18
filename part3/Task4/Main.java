package ru.mephi.java.part3.task4;

public class Main {
    public static void main(String[] args) {
        IntSequence seq = IntSequence.of(1, 2, 3, 4, 5, 6, 7);
        while (seq.hasNext()){
            System.out.println(seq.next());
        }
    }
}
