package ru.mephi.java.part3.myComparator;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public interface MyComparator<T> {
    int compare(T o1, T o2);


    default public   MyComparator<T> reversed(){
        return (c1, c2) -> compare( c2,c1);
    }

    public static MyComparator<Employee> comparing(Function<Employee, String> func) {
        return (c1, c2) -> func.apply(c1).compareTo(func.apply(c2));
    }

    public static MyComparator<Employee> comparing(ToIntFunction<Employee> func) {
        return (MyComparator<Employee>) (c1, c2) -> Integer.compare(func.applyAsInt(c1), func.applyAsInt(c2));
    }

    public static MyComparator<Employee> comparing(Function<Employee, String> func, MyComparator<String> comp) {
        return (c1, c2) -> comp.compare(func.apply(c1), func.apply(c2));

    }


    default MyComparator<T> thenComparing(MyComparator other) {
        return (MyComparator<T>) (c1, c2) -> {
            int res = compare(c1, c2);
            return (res != 0) ? res : other.compare(c1, c2);
        };
    }

    default MyComparator<T> thenComparing(Function<T, String> func) {
        return (MyComparator<T>) (c1, c2) -> {
            int res = compare(c1, c2);
            return (res != 0) ? res : func.apply(c1).compareTo(func.apply(c2));
        };
    }


    default MyComparator<T> thenComparing(ToIntFunction<Employee> func) {
        return (MyComparator<T>) (c1, c2) -> {
            int res = compare(c1, c2);
            return (res != 0) ? res : Integer.compare(func.applyAsInt((Employee) c1), func.applyAsInt((Employee) c2));
        };
    }


    public static MyComparator comparingInt(ToIntFunction<Employee> func) {
        return (MyComparator<Employee>) (c1, c2) -> Integer.compare(func.applyAsInt(c1), func.applyAsInt(c2));
    }


    public static MyComparator naturalOrder() {
        return (MyComparator<String>) (c1, c2) -> {
            return c1.compareTo(c2);
        };
    }

    public static MyComparator nullsFirst(MyComparator comparator) {
        return (c1, c2) -> {
            if (c1 == null) {
                return (c2 == null) ? 0 : -1;
            } else if (c2 == null) {
                return 1;
            } else {
                return comparator.compare(c1, c2);
            }
        };
    }

    public default Comparator<Employee> toComparator() { // сделать instance
        Comparator<T> comp = (first, second) -> this.compare(first, second);
        return (Comparator<Employee>) comp;
    }

}