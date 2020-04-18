package ru.mephi.java.part3.mycomparator;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public interface MyComparator {


    int compare(Employee o1, Employee o2);


    public static MyComparator comparing(Function<Employee, String> func) {
        return (c1, c2) -> func.apply(c1).compareTo(func.apply(c2));
    }

    public static MyComparator comparing(Function<Employee, String> func, MyComparator comp) {
        return (c1, c2) -> comp.compare(func.apply(c1), func.apply(c2));
    }


    default MyComparator thenComparing(MyComparator other) {
        return (MyComparator) (c1, c2) -> {
            int res = compare(c1, c2);
            return (res != 0) ? res : other.compare(c1, c2);
        };
    }

    default MyComparator thenComparing(Function<Employee, String> func) {
        return this.thenComparing(comparing(func));
    }

    default MyComparator thenComparing(ToIntFunction<Employee> func) {
        return this.thenComparing(comparingInt(func));
    }


    public static MyComparator comparingInt(ToIntFunction<Employee> func) {
        return (MyComparator) (c1, c2) -> Integer.compare(func.applyAsInt(c1), func.applyAsInt(c2));
    }

    public static MyComparator naturalOrder() { //исправить employee релизует камперабле.копаре то
        return (MyComparator) (c1, c2) -> {
            int res = c1.getName().compareTo(c2.getName());
            return (res != 0) ? res : Double.compare(c1.getSalary(), (c2.getSalary()));
        };
    }

    public static MyComparator nullsFirst(MyComparator comparator) {
        return (MyComparator) (c1, c2) -> {
            if (c1 == null) {
                return (c2 == null) ? 0 : -1;
            } else if (c2 == null) {
                return 1;
            } else {
                return comparator.compare(c1, c2);
            }
        };
    }

    public static Comparator<Employee> toComparator(MyComparator myComp) { // сделать instance
        Comparator<Employee> comp = (first, second) -> myComp.compare(first, second);
        return comp;

    }
}







