package ru.mephi.java.part4.classLoader;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ClassLoaderUsage {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println(ClassLoaderUsage.class.getClassLoader());
        System.out.println(ArrayList.class.getClassLoader());
        MyClassLoader classLoader = new MyClassLoader();
        Class clazz = classLoader.findClass("C:/Users/ВАР/IdeaProjects/Lec1a/target/classes/ru/mephi/java/part4/task1/Point.class");
        System.out.println(clazz.getName());
        Object point = clazz.getConstructor(double.class, double.class).newInstance(10, 5);
        for (Field f : point.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(point);
            System.out.println(f.getName() + ":" + value);
        }
    }
}
