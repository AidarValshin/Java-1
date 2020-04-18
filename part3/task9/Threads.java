package ru.mephi.java.part3.task9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Threads {
    public static void runTogether(Runnable... tasks) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(tasks.length); //  new thread (task.start)
        for (Runnable task : tasks) {
            es.submit(task);
        }
        es.awaitTermination(1, TimeUnit.SECONDS);
        es.shutdown();
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }
}
