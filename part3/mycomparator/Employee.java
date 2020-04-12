package ru.mephi.java.part3.mycomparator;

public class Employee {
    public int salary;
    public String name;
    public Employee(int salary, String name){
        this.salary=salary;
        this.name=name;
    }
    public String getName(){ return this.name;}
    public int getSalary() { return  this.salary;}
}
