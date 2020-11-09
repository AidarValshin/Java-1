package main.ru.mephi.java.part6.injection;

import main.ru.mephi.java.Employee.Employee;
import main.ru.mephi.java.part6.Additionally.Pair;

import java.util.List;

public class TestClass1 {
    public List<Number> list2;
    public List<? super Number> list;
    protected List<? extends Comparable<? super Employee>> employees;
    private Pair<? extends String, ? super Double> pair;
    private Employee employee;
}
