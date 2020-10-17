package main.ru.mephi.java.part6.extend;

import main.ru.mephi.java.Employee.Employee;
import main.ru.mephi.java.Employee.Manager;

import java.util.ArrayList;

public class Ext {
    public static void readEmpl1(ArrayList<Employee> empl) {
        for (Employee em : empl) {
            System.out.println(em);
        }
    }

    public static void readEmpl2(ArrayList<? extends Employee> empl) {
        for (Employee em : empl) {
            System.out.println(em);
        }
    }

    public static void main(String[] args) {
        Manager m1 = new Manager("Manager1", 1000, 50);
        Manager m2 = new Manager("Manager2", 1000, 500);
        Manager m3 = new Manager("Manager3", 1500, 500);
        ArrayList<Manager> arrayList = new ArrayList<>();
        arrayList.add(m1);
        arrayList.add(m2);
        arrayList.add(m3);
        //   arrayList.add(new Employee("A",100));
        // ArrayList<Employee> arrayList1 = arrayList;
        ArrayList<? extends Employee> arrayList2 = arrayList;
        // readEmpl1(arrayList);
        readEmpl2(arrayList);
    }
}
