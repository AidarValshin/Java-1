package main.ru.mephi.java.part8.task11;

import java.util.stream.Stream;

public class TestFinite {
    private static <T> boolean isFinite(Stream<T> stream) {
        return stream.spliterator().getExactSizeIfKnown() >= 0;
    }

    public static void main(String[] args) {
        System.out.println(isFinite(Stream.of(1,2,3,4,5,6,7)));
        System.out.println(isFinite(Stream.iterate(0,t->t+1)));
    }
}
