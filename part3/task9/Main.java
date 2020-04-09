package ru.mephi.java.part3.task9;

import ru.mephi.java.part3.task8.Great;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.mephi.java.part3.task9.Threads.runInOrder;
import static ru.mephi.java.part3.task9.Threads.runTogether;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> supplierNames = Arrays.asList("task1", "task2", "task3", "task4");
        Runnable[] Tasks1 =new Runnable[4];
        for (int i = 0; i < 4; i++) {
            Tasks1[i]=(new Great(supplierNames.get(i), 5));
        }
        System.out.println("runTogether");
        runTogether( Tasks1);
        System.out.println("runInOrder");
        runInOrder(Tasks1);
    }
}
