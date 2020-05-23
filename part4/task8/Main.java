package ru.mephi.java.part4.task8;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double[] arr = {1.2, 2, 3, 4};
        String prim = "Primitive";
        Circle c = new Circle(1, 1, 4);
        Circle.Point inn = c.getPoint();
        List<Integer> gen = new ArrayList<>();
        gen.add(10);

        Class<?> primitive = prim.getClass();
        Class<?> inner = inn.getClass();
        Class<?> array = arr.getClass();
        Class<?> generic = gen.getClass();

        System.out.println("getName()");
        System.out.println(primitive.getName());
        System.out.println(inner.getName());
        System.out.println(array.getName());
        System.out.println(generic.getName());
        System.out.println(" ");

        System.out.println("getSimpleName()");
        System.out.println(primitive.getSimpleName());
        System.out.println(inner.getSimpleName());
        System.out.println(array.getSimpleName());
        System.out.println(generic.getSimpleName());
        System.out.println(" ");

        System.out.println("getTypeName()");
        System.out.println(primitive.getTypeName());
        System.out.println(inner.getTypeName());
        System.out.println(array.getTypeName());
        System.out.println(generic.getTypeName());
        System.out.println(" ");

        System.out.println(" getCanonicalName()");
        System.out.println(primitive.getCanonicalName());
        System.out.println(inner.getCanonicalName());
        System.out.println(array.getCanonicalName());
        System.out.println(generic.getCanonicalName());
        System.out.println(" ");

        System.out.println("toGenericString()");
        System.out.println(primitive.toGenericString());
        System.out.println(inner.toGenericString());
        System.out.println(array.toGenericString());
        System.out.println(generic.toGenericString());
        System.out.println(" ");

        System.out.println("toString()");
        System.out.println(primitive.toString());
        System.out.println(inner.toString());
        System.out.println(array.toString());
        System.out.println(generic.toString());
        System.out.println(" ");
    }
}

