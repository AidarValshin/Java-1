package ru.mephi.java.part4.classLoader;


import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = MyClassLoader.
                class.getClassLoader();
        URLClassLoader ucl1 = (URLClassLoader) cl;
        for (
                URL u : ucl1.getURLs()) {
            System.out.println(u);
        }

        // file:/C:/dev/git/java-basics/target/classes/
        URL[] urls = ucl1.getURLs();
        URLClassLoader ucl2 = new URLClassLoader(
                urls, cl.getParent());
        Class<?> clazz = Class.forName(
                "ru.mephi.java.ch04.sec04.ClassLoadersUsage",
                true, ucl2);
    }
}
