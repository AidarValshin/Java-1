package ru.mephi.java.part3.task13;

import ru.mephi.java.part3.task8.Great;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<String> supplierNames = Arrays.asList("task1", "task2", "task3", "task4");
        Runnable[] Tasks1 = new Runnable[4];
        for (int i = 0; i < 4; i++) {
            Tasks1[i] = (new Great(supplierNames.get(i), 5));
        }
        RunnableRunInOrder.runInOrder(Tasks1).run();
    }
}

