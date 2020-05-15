package ru.mephi.java.part4.task13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.DoubleFunction;


public class PrintTable {
    public static void printTableDoubleValuesByInvoke(Method method,
                                                      double lower, double upper, double step)
            throws IllegalAccessException, InvocationTargetException {
        if (method == null || method.getParameterTypes().length != 1
                || !(method.getParameterTypes()[0].equals(double.class) && !method.getParameterTypes()[0].equals(Double.class))) {
            throw new IllegalArgumentException("Method must be declareted as Type method(SingleDouble)");
        }
        System.out.println(method.getDeclaringClass().getSimpleName() + " . " + method.getName());
        for (double value = lower; value <= upper; value += step) {
            System.out.println("Value: " + value + " returns: " + method.invoke(method.getDeclaringClass(), value));
        }
    }

    public static void printTableDoubleValuesByDoubleFunction(DoubleFunction<Object> method,
                                                              double lower, double upper, double step) {
        if (method == null) {
            throw new IllegalArgumentException("Null Method");
        }
        System.out.println(method.getClass().getName());
        for (double value = lower; value <= upper; value += step) {
            System.out.println("Value: " + value + " returns: " + method.apply(value));
        }

    }
}
