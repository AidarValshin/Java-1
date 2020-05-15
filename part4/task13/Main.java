package ru.mephi.java.part4.task13;


import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        PrintTable.printTableDoubleValuesByInvoke(Math.class.getDeclaredMethod("sqrt", double.class), 4, 100, 5);
        PrintTable.printTableDoubleValuesByInvoke(Double.class.getDeclaredMethod("toHexString", double.class), 4, 100, 5);

        PrintTable.printTableDoubleValuesByDoubleFunction(Math::sqrt, 4, 100, 5);
        PrintTable.printTableDoubleValuesByDoubleFunction(Double::toHexString, 4, 100, 5);

    }
}

