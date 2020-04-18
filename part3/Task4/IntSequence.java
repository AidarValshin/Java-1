package ru.mephi.java.part3.task4;

public interface IntSequence {
    public static IntSequence of(int... list) {
        // Extra credit for anonymous inner class.
        return new IntSequence() {
            private int pos = 0;


            @Override
            public int next() {
                return  list[pos++] ;
            }
        };
    }

   public default  boolean hasNext(){
        return true;

   }

   public int next();
}

