package main.ru.mephi.java.part6.Additionally;

import main.ru.mephi.java.Employee.Employee;
import main.ru.mephi.java.Employee.Manager;

import java.util.HashMap;
import java.util.Map;

//not producer and not consumer
public class NoPECS {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(); // нет ни extends ни super.
        // ни шагу в сторону.только Т.
        // если передадим наследника,то ломается 1 часть,иначе вторая.
        System.out.println(map.put(1, "a"));
        System.out.println(map.put(1, "и"));
        map.forEach((k, v) -> System.out.println("key " + k + ",value " + v));
        System.out.println();

        Map<Integer, Employee> mapEmpl = new HashMap<>(); // нет ни extends ни super.
        // ни шагу в сторону.только Т.
        System.out.println(mapEmpl.put(1, new Manager("b",200,100)));
        Employee manager =  mapEmpl.put(1, new Employee("a",100));
        System.out.println(manager);
        mapEmpl.forEach((k, v) -> System.out.println("key " + k + ",value " + v));
        System.out.println();

        Map<Integer, Employee> mapEmpl1= new HashMap<>();
        Map<Integer, Employee> mapEmpl2=mapEmpl1;
        Employee empl=mapEmpl2.put(2,new Employee("v", 1));
    }
}

