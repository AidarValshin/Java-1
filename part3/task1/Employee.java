package ru.mephi.java.part3.task1;



public class Employee implements Measurable {
    private double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    @Override
    public double getMeasure() {
        return this.salary;
    }

    public static  double average(Measurable[] objects) {
        int cnt=0;
        double summ=0;
        for ( Measurable i : objects) {
            summ+=i.getMeasure();
            cnt+=1;
        }
        return summ/cnt;
    }
}