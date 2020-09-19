package main.ru.mephi.java.part5.handleExceptions;

import main.ru.mephi.java.part5.task1.ReadValuesFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class HandleExceptions {
    public static void printCatch(String message) {
        try {
            Objects.requireNonNull(message, " String can not be null");
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println(0);
            e.printStackTrace();
        }
    }

    public static void printRethrown(String message) {
        try {
            Objects.requireNonNull(message, " String can not be null");
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println(0);
            throw e;
        }
    }

    public static void printChained(String filename) {
        ReadValuesFile readValuesFile = new ReadValuesFile();
        try {
            ArrayList<Double> arrayList1 = readValuesFile
                    .readValues(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Go to unchecked exception ");
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {
        String nullString = null;
//        printCatch(null); // continue
        //    printRethrown(null); // exit
        printChained("c/main/ru/mephi/resources/part5.ex1_1");
    }
}
