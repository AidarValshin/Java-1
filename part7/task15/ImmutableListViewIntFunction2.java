package main.ru.mephi.java.part7.task15;

import java.util.function.IntFunction;

public class ImmutableListViewIntFunction2 {
    public static Integer immutableListView(IntFunction<Integer> intFunction, int i ) {
        return intFunction.apply(i);
    }
}
