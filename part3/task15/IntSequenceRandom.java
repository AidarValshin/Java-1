package ru.mephi.java.part3.task15;
//Implement the RandomSequence in Section 3.9.1, “Local Classes,” on p. 122 as
//a nested class, outside the randomInts method.

import ru.mephi.java.part3.task4.IntSequence;

import java.util.Random;

public class IntSequenceRandom {
    private static Random generator = new Random();

    private static class RandomSequence implements IntSequence {
        public int low;
        public int high;

        RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        public int next() {
            return low + generator.nextInt(high - low + 1);
        }

        public boolean hasNext() {
            return true;
        }
    }

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }
}
