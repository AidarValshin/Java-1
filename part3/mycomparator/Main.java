package ru.mephi.java.part3.mycomparator;


import java.util.Arrays;

import java.util.Comparator;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        List<String> supplierNames = Arrays.asList("DDDD", "A", "CCC", "BB");
        Employee[] employee = new Employee[8];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                employee[2 * i + j] = new Employee(1000 - 10 * (j + i), supplierNames.get(i));
            }
        }
        System.out.println("AS IS");
        print(employee,employee.length);

        System.out.println("comparing(Employee::getName)");
        Arrays.sort(employee, Comparator.comparing(Employee::getName));
        print(employee,employee.length);
        Arrays.sort(employee, MyComparator.comparing(Employee::getName));
        print(employee,employee.length);

        System.out.println("thenComparing(Employee::getSalary)");
        Arrays.sort(employee, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        print(employee,employee.length);
        Arrays.sort(employee, MyComparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        print(employee,employee.length);

        System.out.println("comparingInt((s)->s.getName().length()");
        Arrays.sort(employee, Comparator.comparingInt((s)->s.getName().length()));
        print(employee,employee.length);
        Arrays.sort(employee, MyComparator.comparingInt((s)->s.getName().length()));
        print(employee,employee.length);

        System.out.println("comparingInt(Employee::getSalary)");
        Arrays.sort(employee, Comparator.comparingInt(Employee::getSalary));
        print(employee,employee.length);
        Arrays.sort(employee, MyComparator.comparingInt(Employee::getSalary));
        print(employee,employee.length);

        System.out.println(" comparing(Employee::getName, (s,t) -> s.length() - t.length())");
        Arrays.sort(employee, Comparator.comparing(Employee::getName, (s,t) -> s.length() - t.length()));
        print(employee,employee.length);
        Arrays.sort(employee, MyComparator.comparing(Employee::getName, (s,t) -> s.length() - t.length()));
        print(employee,employee.length);

        System.out.println("thenComparing(Employee::getName)");
        Arrays.sort(employee, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
        print(employee,employee.length);
        Arrays.sort(employee, MyComparator.comparingInt (Employee::getSalary).thenComparing(Employee::getName));
        print(employee,employee.length);
        Employee[] employee1 = new Employee[9];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                employee1[2 * i + j] = new Employee(1000 - 10 * (j + i), supplierNames.get(i));
            }
        }
        employee1[8]=new Employee(50 , null);
        System.out.println("AS IS with null");
        print(employee1, employee1.length);

        System.out.println("nullsFirst(Comparator.naturalOrder()");
        Arrays.sort(employee1, MyComparator.comparing(Employee::getName,Comparator.nullsFirst(Comparator.naturalOrder())));
       print(employee1,employee1.length);
        Arrays.sort(employee1, Comparator.comparing(Employee::getName,Comparator.nullsFirst(Comparator.naturalOrder())));
       print(employee1,employee1.length);

    }


    private static void print (Employee[] employee,int n) {
        System.out.println(" ");
        for (int i = 0; i < n; i++) {
            System.out.println(employee[i].name + " " + employee[i].salary);
        }
        System.out.println();
    }
}
