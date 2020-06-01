package ru.mephi.java.part4.classLoader;
/*

import ru.mephi.java.part4.task1.Point;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ClassLoaderUsage {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        System.out.println(ClassLoaderUsage.class.getClassLoader());
        System.out.println(ArrayList.class.getClassLoader());
        MyClassLoader classLoader = new MyClassLoader();
        Class clazz = classLoader.loadClass("C:/Users/ВАР/IdeaProjects/Lec1a/target/classes/ru/mephi/java/part4/task1/Point.class");
      //  Class clazz = classLoader.loadClass("ru.mephi.java.part4.task1.Point");
        System.out.println(clazz.getName());
        Object point = clazz.getConstructor(double.class, double.class).newInstance(10, 5);
        for (Field f : point.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(point);
            System.out.println(f.getName() + ":" + value);
        }
        Class.forName("ru.mephi.java.part4.task1.Point");// у моего класс лоадер по типу этого
        System.out.println(classLoader.getParent());
        Point p= (Point) clazz.getConstructor(double.class, double.class).newInstance(10, 5); //ClassCastException
    }
}


 */