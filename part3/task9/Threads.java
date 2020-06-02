package ru.mephi.java.part3.task9;

//Implement methods
//Click here to view code image
//public static void runTogether(Runnable… tasks)
//public static void runInOrder(Runnable… tasks)
//The first method should run each task in a separate thread and then return. The
//second method should run all methods in the current thread and return when the last
//one has completed.
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
