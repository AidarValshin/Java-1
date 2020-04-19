package ru.mephi.java.part3.task9;

import ru.mephi.java.part3.task8.Great;

import java.util.Arrays;
import java.util.List;

import static ru.mephi.java.part3.task9.Threads.runInOrder;
import static ru.mephi.java.part3.task9.Threads.runTogether;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> supplierNames1 = Arrays.asList("together task1", "together task2", "together task3", "together task4");
        List<String> supplierNames2 = Arrays.asList("in order task1", "in order task2", "in order task3", "in order task4");
        Runnable[] Tasks1 = new Runnable[4];
        for (int i = 0; i < 4; i++) {
            Tasks1[i] = (new Great(supplierNames1.get(i), 5));
        }

        runTogether(Tasks1);
        Runnable[] Tasks2 = new Runnable[4];
        for (int i = 0; i < 4; i++) {
            Tasks2[i] = (new Great(supplierNames2.get(i), 5));
        }
        runInOrder(Tasks2);
    }
}
