package ru.mephi.java.part3.task2;

import static ru.mephi.java.part3.task2.Employee.largest;

public class Main {
    public static void main(String[] args) {
        Employee [] e = new Employee[10] ;
        for(int i=10;i>0;i--){
            e[i-1]=new Employee(i);
        }
        Measurable larg_employee =largest(e);
        if(larg_employee instanceof Employee){
            Employee empl=(Employee)larg_employee;
            System.out.println(empl.getMeasure());
        }

    }
}
