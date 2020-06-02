package ru.mephi.java.part1.task12;

public class LabeledBreak {
    public static void main(String args[]) {
        second:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1) {
                    break second;
                }

                System.out.print(" [i = " + i + ", j = " + j + "] ");
            }
        }
    }
}

