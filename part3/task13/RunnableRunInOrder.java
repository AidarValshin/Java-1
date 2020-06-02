package ru.mephi.java.part3.task13;

//Write a method that takes an array of Runnable instances and returns a
//Runnable whose run method executes them in order. Return a lambda
//expression.

public class RunnableRunInOrder {
    public static Runnable runInOrder(Runnable... tasks) {
        return () -> {
            for (Runnable task : tasks) {
                task.run();
            }
        };
    }
}