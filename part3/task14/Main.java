package ru.mephi.java.part3.task14;

//Write a call to Arrays.sort that sorts employees by salary, breaking ties by
//name. Use Comparator.thenComparing. Then do this in reverse order.

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> supplierNames = Arrays.asList("D", "A", "C", "B");
        Employee[] e = new Employee[8];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                e[2 * i + j] = new Employee(100 + 10 * (j + i), supplierNames.get(i));
            }
        }
        Arrays.sort(e, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
        for (int i = 0; i < 8; i++) {
            System.out.println(e[i].name + " " + e[i].salary);
        }
        System.out.println("reversed");
        Arrays.sort(e, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName).reversed());
        for (int i = 0; i < 8; i++) {
            System.out.println(e[i].name + " " + e[i].salary);
        }
    }

}
