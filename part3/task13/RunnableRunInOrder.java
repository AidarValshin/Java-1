package ru.mephi.java.part3.task13;

public class RunnableRunInOrder {
    public static Runnable runInOrder(Runnable... tasks) {
        return () -> {
            for (Runnable task : tasks) {
                task.run();
            }
        };
    }
}