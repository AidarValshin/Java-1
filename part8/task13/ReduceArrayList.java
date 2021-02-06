package main.ru.mephi.java.part8.task13;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceArrayList {
    public static <T> ArrayList<T> reduceArrayList1(Stream<ArrayList<T>> stream) {
        Optional<ArrayList<T>> reduceResult = stream.reduce((a, b) -> {
            a.addAll(b);
            return a;
        });
        return reduceResult.orElse(new ArrayList<>());
    }

    public static <T> ArrayList<T> reduceArrayList2(Stream<ArrayList<T>> stream) {
        ArrayList<T> reduceResult = stream.reduce(new ArrayList<T>(), (a, b) -> {
            a.addAll(b);
            return a;
        });
        return reduceResult;
    }

    public static <T> ArrayList<T> reduceArrayList3(Stream<ArrayList<T>> stream) {
        ArrayList<T> reduceResult = stream.reduce(new ArrayList<T>(), (a, b) -> {
                    a.addAll(b);
                    return a;
                },
                (a, b) -> {
                    a.addAll(b);
                    return a;
                });
        return reduceResult;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(2);
        integers1.add(3);
        ArrayList<Integer> integers2 = new ArrayList<>();
        integers2.add(4);
        integers2.add(5);
        integers2.add(6);
        Stream<ArrayList<Integer>> arrayListStream = Stream.of(integers1, integers2);
        reduceArrayList1(arrayListStream).forEach(System.out::println);
        arrayListStream = Stream.of(integers1, integers2);
        reduceArrayList2(arrayListStream).forEach(System.out::println);
        ArrayList<Integer> integers3 = new ArrayList<>();
        integers3.add(4);
        integers3.add(5);
        integers3.add(6);
        ArrayList<Integer> integers4 = new ArrayList<>();
        integers4.add(4);
        integers4.add(5);
        integers4.add(6);
        arrayListStream = Stream.of(integers1, integers2,integers3,integers4
                ,integers1, integers2,integers3,integers4
        ,integers1, integers2,integers3,integers4).parallel();
        reduceArrayList3(arrayListStream).forEach(System.out::println);
    }
}
