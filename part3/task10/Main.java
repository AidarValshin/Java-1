package ru.mephi.java.part3.task10;

import java.io.File;

import static ru.mephi.java.part3.task10.Subdirectories.getSubdirectories;

public class Main {
    public static void main(String args[]) {
        // dir
        File dir = new File(".");
        // read files
        File[] lst1 = dir.listFiles();
        System.out.println("lst1.length = " + lst1.length);
        System.out.println("lst2.length = " + getSubdirectories(".").size());
    }
}
