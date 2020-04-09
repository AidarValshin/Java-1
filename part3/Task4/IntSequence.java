package ru.mephi.java.part3.Task4;

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
                return  list[pos++] ;
            }
        };
    }

    boolean hasNext();

    int next();
}

