package ru.mephi.java.part1.Task12;

public class UnlabeledBreak {
    public static void main(String args[]) {
        boolean done=true;
        for (int i = 0; i < 3; i++) {
            if (done == true) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1) {
                        done = false;
                        break;
                    }

                    System.out.print(" [i = " + i + ", j = " + j + "] ");
                }
            }

        }
    }
}

