package ru.mephi.java.part3.task4;

//Implement a static of method of the IntSequence class that yields a sequence
//with the arguments. For example, IntSequence.of(3, 1, 4, 1, 5, 9)
//yields a sequence with six values. Extra credit if you return an instance of an
//anonymous inner class.
public interface IntSequence {
    public static IntSequence of(int... list) {
        //  anonymous inner class.
        // lambda cannot override  hasNext
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

    public boolean hasNext();

    public int next();
}

