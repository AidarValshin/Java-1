package main.ru.mephi.java.part7.task5;

import java.util.*;

public class SwapInList {
    public static void swap(List<?> list, int i, int j) {
        if (i >= list.size() || j >= list.size()) {
            throw new IllegalArgumentException("out of range");
        }
        if (i == j) {
            return ;
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
        ListIterator<E> listIterator = list.listIterator(i);// i / n-i
        E first = listIterator.next();
        for (int count = i + 1; count < j; count++) { // j-i / n-j
            listIterator.next();
        }
        E second = listIterator.next();
        listIterator.set(first);
        if (j - i < i) { // j-i
            for (int count = j; count > i; count--) {
                listIterator.previous();
            }
            listIterator.previous();
            listIterator.set(second);
        }
        else{  // i
            list.set(i,second);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        swap(list,0,9);
        list.forEach(System.out::println);
        System.out.println();
        swap(list,5,6);
        list.forEach(System.out::println);
        System.out.println();
        swap(list,7,9);
        list.forEach(System.out::println);
    }
}
