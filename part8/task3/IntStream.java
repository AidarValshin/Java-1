package main.ru.mephi.java.part8.task3;

import java.util.stream.Stream;

public class IntStream {
    public static void main(String[] args) {
        int[] values = { 1, 4, 9, 16 };
        Stream.of(values).forEach(System.out::println);
        System.out.println();
        java.util.stream.IntStream.of(values).forEach(System.out::println);
    }
}
