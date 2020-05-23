package ru.mephi.java.part4.task9;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class UniversalToString1 {
        public static String toString(Object obj) throws IllegalAccessException {
            StringBuilder result = new StringBuilder();
            Class<?> cl = obj.getClass();
            while (cl != null) {
                result.append(cl.getSimpleName() + ": \n");
                for (Field f : obj.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    Object value = f.get(obj);
                    result.append(f.getType() + "  " + f.getName() + ":" + value + "\n");

                }
                cl = cl.getSuperclass();
            }
            return result.toString();

    }
}
