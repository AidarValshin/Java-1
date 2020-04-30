package ru.mephi.java.part3.myComparator;

public class Employee implements Comparable<Employee> {
    public int salary;
    public String name;
    public Employee(int salary, String name){
        this.salary=salary;
        this.name=name;
    }
    public String getName(){ return this.name;}
    public int getSalary() { return  this.salary;}

    @Override
    public int compareTo(Employee employee) {
        int res = this.name.compareTo(employee.name);
        return (res != 0) ? res : Integer.compare(this.getSalary(), (employee.getSalary()));

    }
}
