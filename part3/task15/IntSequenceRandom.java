package ru.mephi.java.part3.task15;

import ru.mephi.java.part3.Task4.IntSequence;

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
