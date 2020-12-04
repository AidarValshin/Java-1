package main.ru.mephi.java.part7.task14;

import java.util.Iterator;


public class ImmutableListView {
    public static Iterator<Integer> immutableListView(int n) {
        return new Iterator<>() {
            private int current;

            @Override
            public boolean hasNext() {
                return this.current <= n;
            }

            @Override
            public Integer next() {
                if (this.current > n) {
                    throw new IndexOutOfBoundsException("out of bound");
                }
                return this.current++;
            }
        };
    }

    public static void main(String[] args) {
        Iterator<Integer> iterator = immutableListView(10);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
