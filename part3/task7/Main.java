package ru.mephi.java.part3.task7;

import ru.mephi.java.part3.mycomparator.Employee;
import ru.mephi.java.part3.mycomparator.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        ArrayList<String> ar = new ArrayList<String>();
        ar.add(b);
        ar.add(a);
        ar.add(c);
        Lucky.luckySort(ar, new Sortbyname());
        System.out.println(ar);

        ArrayList<Integer> ar1 = new ArrayList<Integer>();
        ar1.add(3);
        ar1.add(1);
        ar1.add(2);
        Lucky.luckySort(ar1, new SortInt());
        System.out.println(ar1);

        List<String> supplierNames = Arrays.asList("DDDD", "A", "CCC", "BB");
        ArrayList<Employee> ar2 = new ArrayList<Employee>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                ar2.add(new Employee(1000 - 10 * (j + i), supplierNames.get(i)));
            }
        }
        Lucky.luckySort(ar2, MyComparator.comparing(Employee::getName).thenComparing(Employee::getSalary).toComparator());
        Lucky.print(ar2, ar2.size());
    }

    public static class Sortbyname implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    }

    public static class SortInt implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return Integer.compare(a, b);
        }

    }


}

