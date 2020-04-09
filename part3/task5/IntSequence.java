package ru.mephi.java.part3.task5;

interface IntSequence {
    static IntSequence of(int... list) {
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

    static IntSequence constant(int c) {
        return () -> c;
    }

    default boolean hasNext() {
        return true;
    }

    int next();
}

