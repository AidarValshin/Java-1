package main.ru.mephi.java.part7.task5;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class SwapInList {
    public static void swap(List<?> list, int i, int j) {
        if (i >= list.size() || j >= list.size()) {
            throw new IllegalArgumentException("out of range");
        }
        if (i == j) {
            throw new IllegalArgumentException("i==j. Nothing to change");
        }
        if (list instanceof RandomAccess) {
            Collections.swap(list, i, j);
        } else {
            sequentialAccessSwapHelper(list, i, j);
        }
    }

    private static <E> void sequentialAccessSwap(List<E> list, int i, int j) {
        if (i < j) {
            sequentialAccessSwapHelper(list, i, j);
        } else {
            sequentialAccessSwapHelper(list, j, i);
        }
    }

    private static <E> void sequentialAccessSwapHelper(List<E> list, int i, int j) {
        ListIterator<E> listIterator = list.listIterator(i);
        E first = listIterator.next();
        for (int count = i + 1; count < j; count++) {
            listIterator.next();
        }
        E second = listIterator.next();
        listIterator.set(first);
        for (int count = j; count > i; count--) {
            listIterator.previous();
        }
        listIterator.set(second);
    }

}
