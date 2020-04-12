package ru.mephi.java.part3.task2;

interface Measurable {
    double getMeasure();
}

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

    public static Measurable largest(Measurable[] objects){
        Measurable res=null;
        double val1=0;
        double val2=0;
        for ( Measurable i : objects) {
            val2+=i.getMeasure();
            if(val2>val1)
            {   val1=val2;
                res=i;
            }
        }
        return res;
    }
}