package ru.mephi.java.part1.task12;

public class UnLabeledCont {
    public static void main(String args[]) {
        boolean done=true;
        for (int i = 0; i < 3; i++) {
            if(done==true) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1) {

                        done=false;
                        continue;

                    }
                    System.out.print(" [i = " + i + ", j = " + j + "] ");
                }
            }
            done=true;
        }
    }
}

