package main.ru.mephi.java.part8.task12;

import java.util.Iterator;
import java.util.stream.Stream;

public class UnionStreams {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();
        Stream.Builder<T> builder = Stream.builder();
        while (iteratorFirst.hasNext() || iteratorSecond.hasNext()) {
            if (iteratorFirst.hasNext()) {
                builder.accept(iteratorFirst.next());
            } else {
                builder.accept(null);
            }
            if (iteratorSecond.hasNext()) {
                builder.accept(iteratorSecond.next());
            } else {
                builder.accept(null);
            }
        }
        return builder.build();
    }

    public static void main(String[] args) {
        Stream<Integer> integerStream1 = Stream.of(1, 3, 5, 7);
        Stream<Integer> integerStream2 = Stream.of(2, 4, 6, 8, 10, 12, 14, 16, 18);
zip(integerStream1,integerStream2).forEach(System.out::println);
    }
}
