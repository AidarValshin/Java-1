package main.ru.mephi.java.part7.task15;

import java.util.Iterator;
import java.util.function.IntFunction;


public class ImmutableListViewIntFunction {
    public static Iterator<Integer> immutableListView(IntFunction<Integer> intFunction) {
        return new Iterator<>() {
            private int current=0;
            private IntFunction<Integer> func = intFunction;

            @Override
            public boolean hasNext() {
                return this.current != intFunction.apply(this.current);
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    this.current=intFunction.apply(this.current);
                    return this.current;
                }
                throw new IndexOutOfBoundsException("out of bound");
            }
        };
    }

    public static void main(String[] args) {
        Iterator<Integer> iterator = immutableListView(p->p<10? ++p:p);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}



