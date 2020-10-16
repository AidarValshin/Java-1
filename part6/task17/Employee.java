package main.ru.mephi.java.part6.task17;

public class Employee implements Comparable<Employee> {
private String name;
private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee employee) {
       return Integer.compare(this.salary,employee.salary);
    }

    public static void main(String[] args) {
        Employee em1=new Employee("A",100);
        Employee em2=new Employee("B",1000);
        System.out.println(em2.compareTo(em1));
    }
}
//c:\Program Files\Java1\jdk-13.0.2\bin\
// javap