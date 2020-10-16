package main.ru.mephi.java.part6.task15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Map {

    public static <R, T> List<R> map(List<? extends T> input, Function<? super T, R> function) {
        ArrayList<R> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            output.add(function.apply(input.get(i)));
        }
        return output;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);
        List<String> stringArrayList = map(arrayList, integer -> Integer.toString(integer + 4));
        stringArrayList.forEach(System.out::println);
        System.out.println(stringArrayList.get(0).getClass());
    }
}
