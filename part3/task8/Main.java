package ru.mephi.java.part3.task8;

public class Main {
    public static void main(String[] args) {
        Runnable Task1 = new Great("Aidar", 15);
        Thread t1 = new Thread(Task1);
        Runnable Task2 = new Great("Ramil", 15);
        Thread t2 = new Thread(Task2);
        t1.start();
        t2.start();


    }
}
