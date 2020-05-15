package ru.mephi.java.part4.task9;

import java.lang.reflect.Field;


public class UniversalToString {
    public static String toString(Object obj) throws IllegalAccessException {
        StringBuilder result = new StringBuilder();
        result.append(obj.getClass().getSimpleName() + ": \n");
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(obj);
            result.append(f.getType() +"  "+ f.getName() + ":" + value + "\n");

        }
        return result.toString();
    }
}
