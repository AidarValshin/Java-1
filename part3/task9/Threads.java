package ru.mephi.java.part3.task9;


public class Threads {
    public static void runTogether(Runnable... tasks) {
        System.out.println("runTogether");
        for (int i = 0; i < tasks.length; i++) {
            Thread thread = new Thread(tasks[i]);
            thread.start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        System.out.println("runInOrder");
        for (Runnable task : tasks) {
            task.run();
        }
    }
}
