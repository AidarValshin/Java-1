package main.ru.mephi.java.part6.task21;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Arrays {
    @SafeVarargs
    public static <T> T[] construct(int size, T... args) {
        Class cl = args.getClass();

        T[] newArray = (T[]) java.lang.reflect.Array.newInstance(
                args.getClass().getComponentType(), size);

        int i = 0;
        for (T a : args) {
            if (i < newArray.length) {
                newArray[i] = a;
                i++;
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(5);
        list3.add(6);
        List<Integer>[] result = Arrays.construct(4, list1, list2, list3);
        System.out.println(result.length);
        System.out.println(result[0].size());
        System.out.println(result[2].get(0));
        System.out.println(result[2].get(1));
        System.out.println(result[2].getClass().getName());
        System.out.println(Objects.isNull(result[3]));
    }

}
