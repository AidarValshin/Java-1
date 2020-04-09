package ru.mephi.java.part3.task1;
 import static  ru.mephi.java.part3.task1.Employee.average;

public class Main {
    public static void main(String[] args) {
        Employee [] e = new Employee[10] ;
        for(int i=1;i<11;i++){
            e[i-1]=new Employee(i);
        }
        System.out.println(average(e));
    }
}
