package main.ru.mephi.java.part6.task19;

import java.util.ArrayList;

public class Repeat {
    public static <T> ArrayList<T> repeat(int n, T obj) {
        ArrayList<T> result = new ArrayList<>(); // OK
        for (int i = 0; i < n; i++) result.add(obj);
        return result;
    }

    //можно только через рефлексию достать класс
    public static <T> T[] convert(ArrayList<T> arrayList) {
        @SuppressWarnings("unchecked") T[] newArray = (T[]) java.lang.reflect.Array.newInstance(
                arrayList.get(0).getClass(), arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            newArray[i] = arrayList.get(i);
        }
        return newArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = repeat(10, 1);
        System.out.println(arrayList);
        Integer[] arr = convert(arrayList);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
