package ru.mephi.java.part1.task12;
public class LabeledCont {
    public static void main(String args[]) {
    first:
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (i == 1) {
                continue first;
            }
            System.out.print(" [i = " + i + ", j = " + j + "] ");
        }
    }
}
}