package main.ru.mephi.java.part6.task9_11;

import main.ru.mephi.java.part6.task7.Pair;

import java.util.ArrayList;

public class Arrays {
    //9
    public static <E> Pair<E> firstLast(ArrayList<? extends E> a) {
        return new Pair<>(a.get(0), a.get(a.size() - 1));
    }

    //10
    public static <E extends Comparable<E>> E min(ArrayList<? extends E> a) {
        E min = a.get(0);
        for (E e : a) {
            if (min.compareTo(e) > 0) {
                min = e;
            }
        }
        return min;
    }

    public static <E extends Comparable<E>> E max(ArrayList<? extends E> a) {
        E max = a.get(0);
        for (E e : a) {
            if (max.compareTo(e) < 0) {
                max = e;
            }
        }
        return max;
    }

    //11
    public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<? extends E> a) {
        return new Pair<>(min(a), max(a));
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(1);
        System.out.println(firstLast(arrayList));
        System.out.println(minMax(arrayList));
    }
}
