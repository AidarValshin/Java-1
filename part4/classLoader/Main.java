package ru.mephi.java.part4.classLoader;

import ru.mephi.java.part4.task1.Point;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(Main.class.getClassLoader());
        System.out.println(Main.class.getClassLoader().getParent());
        System.out.println(Main.class.getClassLoader().getParent().getParent());
        String path = "C:/Users/ВАР/IdeaProjects/Lec1a/target/classes/";
        MyClassLoader classLoader = new MyClassLoader(path, Main.class.getClassLoader().getParent());
        Class clazz = classLoader.loadClass("ru.mephi.java.part4.task1.Point");
        Class clazz1 = classLoader.loadClass("ru.mephi.java.part4.task1.Point");
        System.out.println(clazz.getName());
        Object point = clazz.getConstructor(double.class, double.class).newInstance(10, 5);
        for (Field f : point.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Object value = f.get(point);
            System.out.println(f.getName() + ":" + value);
        }

        System.out.println(classLoader.getParent());
        System.out.println(point.getClass().getClassLoader());
        // Class.forName("ru.mephi.java.part4.task1.Point");// у моего класс лоадер по типу этого
        Point p = (Point) clazz.getConstructor(double.class, double.class).newInstance(11, 5);
    }

}

