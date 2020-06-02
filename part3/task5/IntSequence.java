package ru.mephi.java.part3.task5;
//Implement a static constant method of the IntSequence class that yields an
//infinite constant sequence. For example, IntSequence.constant(1) yields
//values 1 1 1 … , ad infinitum. Extra credit if you do this with a lambda
//expression.

public interface IntSequence {
    public static IntSequence of(int... list) {
        // Extra credit for anonymous inner class.
        return new IntSequence() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < list.length;
            }

            @Override
            public int next() {
                return list[pos++];
            }

        };
    }

    public static IntSequence constant(int c) {
        return () -> c;
    }

    public default boolean hasNext() {
        return true;
    }

    public int next();
}

