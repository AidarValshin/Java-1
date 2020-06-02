package ru.mephi.java.part4.task11;

//Write the “Hello, World” program, using reflection to look up the out field of
//java.lang.System and using invoke to call the println method.

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloWorld {
    public static void printHello() throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class cl = System.class;
        Field out = cl.getField("out");
        out.setAccessible(true);
        Class type = out.getType();
        Method method = type.getDeclaredMethod("println", String.class);
        method.invoke(out.get(null), "Hello world");
    }
}
