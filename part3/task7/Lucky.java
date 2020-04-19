package ru.mephi.java.part3.task7;

import ru.mephi.java.part3.mycomparator.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * the worth algorithm complexity is O(N*N!). N! are the all numbers of permutations.
 * quicsort average O(nLogn)
 */
public class Lucky {
    public static <T> void luckySort(ArrayList<T> arr, Comparator<T> comp) {
        T first;
        T second = arr.get(0);
        boolean fl = true;
        while (fl) { //O(N)
            fl = false;
            for (int i = 0; i < arr.size(); i++) {
                first = arr.get(i);
                if (arr.size() > i + 1) {
                    second = arr.get(i + 1); //Change here
                }
                if (comp.compare(first, second) > 0) {
                    fl = true;
                    break;
                }
            }
            if (fl) {
                Collections.shuffle(arr); //O(N)
            }
        }
    }

    public static void print(ArrayList<Employee> employee, int n) {
        System.out.println(" ");
        for (int i = 0; i < n; i++) {
            System.out.println(employee.get(i).name + " " + employee.get(i).salary);
        }
        System.out.println();
    }
}
