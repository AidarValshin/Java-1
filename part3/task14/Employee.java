package ru.mephi.java.part3.task14;

public class Employee {
    public double salary;
    public String name;
    public Employee(double salary, String name){
        this.salary=salary;
        this.name=name;
    }
    public String getName(){ return this.name;}
    public double getSalary() { return  this.salary;}
}
