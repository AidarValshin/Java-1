package main.ru.mephi.java.part6.task12_13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Arrays {
    public static <T> void minmax(List<? extends T> elements,
                                  Comparator<? super T> comp, List<? super T> result) {
        T min = elements.get(0);
        T max = elements.get(0);
        for (T e : elements) {
            if (comp.compare(min, e) > 0) {
                min = e;
            }
            if (comp.compare(max, e) < 0) {
                max = e;
            }
        }
        result.add(min);
        result.add(1, max);
    }

    //12
    public static <T> void maxmin(List<? extends T> elements,
                                  Comparator<? super T> comp, List<? super T> result) {
        minmax(elements, comp, result);
        Arrays.swapHelper(result, 0, 1);
    }

    private static <T> void swapHelper(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);

        ArrayList<Integer> result = new ArrayList<>();
        minmax(arrayList, Integer::compareTo, result);
        result.forEach(System.out::println);

        ArrayList<Integer> resultMaxMin = new ArrayList<>();
        maxmin(arrayList, Integer::compareTo, resultMaxMin);
        resultMaxMin.forEach(System.out::println);
    }
}
