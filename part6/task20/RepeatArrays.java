package main.ru.mephi.java.part6.task20;


import java.util.Arrays;

public class RepeatArrays {
    @SafeVarargs
    public static final <T> T[] repeat(int n, T... objs) {
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) java.lang.reflect.Array.newInstance(objs.getClass()
                .getComponentType(), n * objs.length);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < objs.length; j++) {
                arr[i * objs.length + j] = objs[j];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Arrays.stream(repeat(10, 1, 2, 3, 4, 5, 6, 7, 8, 9))
                .forEach(System.out::println);
    }
}
