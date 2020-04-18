package ru.mephi.java.part3.task4;

public interface IntSequence {
    public static IntSequence of(int... list) {
        //  anonymous inner class.
        //нельзя сделать,т.к. лямбда выражение в отличие от класса не может переопределить метод hasNext
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

   public  boolean hasNext();

   public int next();
}

