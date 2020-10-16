package main.ru.mephi.java.part6.task6;

import main.ru.mephi.java.Employee.Employee;
import main.ru.mephi.java.Employee.Manager;

import java.util.ArrayList;

public class Append {

    public static  <T>  void append1(ArrayList<T> source, ArrayList<? extends T> producer){
         source.addAll(producer);
    }

    public static <T>  void append2(ArrayList<? super T> source, ArrayList<T> producer){
        source.addAll(producer);
    }

    public static void main(String[] args) {
        ArrayList<Employee> arrayList1=new ArrayList<>();
        arrayList1.add(new Employee("A",1000));
        arrayList1.add(new Manager("Manager",1000,500));
        ArrayList<Employee> arrayList2=new ArrayList<>();
        append1(arrayList2,arrayList1);
        arrayList2.forEach(System.out::println);
        arrayList2=new ArrayList<>();
        append2(arrayList2,arrayList1);
        arrayList2.forEach(System.out::println);
    }

}
