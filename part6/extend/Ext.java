package main.ru.mephi.java.part6.extend;

import main.ru.mephi.java.Employee.Employee;
import main.ru.mephi.java.Employee.Manager;

import java.util.ArrayList;

public class Ext {
    public static void readEmplName1(ArrayList<Employee> empl) {
        for (Employee em : empl) {
            System.out.println(em.getName());
        }
            }

    public static void readEmplName2(ArrayList<? extends Employee> empl) {
        for (Employee em : empl) {
            System.out.println(em.getName());
        }
       // empl.add(new Manager("A",100,100));
    }

    public static void main(String[] args) {
        Manager m1 = new Manager("Manager1", 1000, 50);
        Manager m2 = new Manager("Manager2", 1000, 500);
        Manager m3 = new Manager("Manager3", 1500, 500);
        ArrayList<Manager> arrayList = new ArrayList<>();
        arrayList.add(m1);
        arrayList.add(m2);
        arrayList.add(m3);
        // arrayList.add(new Employee("A",100));
        // ArrayList<Employee> arrayList1 = arrayList;  // инвариантность дженериков
        Employee[] employees = new Manager[5]; // ковариатость массивов
        employees[0] = new Employee("A", 100);
        ArrayList<? extends Employee> arrayList2 = arrayList;
        //   readEmplName1(arrayList); //инвариантность  дженериков
        readEmplName2(arrayList);
    }
}
