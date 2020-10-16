package main.ru.mephi.java.part6.task5;

public class Swap {

    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public static void main(String[] args) {
        // Double[] result = Swap.swap(0, 1, 1.5, 2, 3);
        // Double[] result = (Double[]) Swap.swap(0, 1, 1.5, 2, 3);
        // Double[] result =  Swap.swap(0, 1, 1.5, 2d, 3d);
        Double[] result = Swap.<Double>swap(0, 1, 1.5, 2d, 3d);
        System.out.println(result[0]);
    }

}
