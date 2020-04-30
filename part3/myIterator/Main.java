package ru.mephi.java.part3.myIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> states = new ArrayList<String>();
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Spain");

        Iterator<String> it0 = states.iterator();
        MyIterator iter0 = MyIterator.fromIterator(it0);
        while (iter0.hasNext()) {

            System.out.println(iter0.next());
        }
        System.out.println(" ");
        System.out.println("union");
        Iterator<String> it1 = states.iterator();
        MyIterator iter1 = MyIterator.fromIterator(it1);
        Iterator<String> it2 = states.iterator();
        MyIterator iter2 = iter1.union(MyIterator.fromIterator(it2));
        Iterator<String> it3 = states.iterator();
        MyIterator iter3 = MyIterator.fromIterator(it3);
        iter3 = iter3.union(iter2);
        while (iter3.hasNext()) {
            System.out.println(iter3.next());
        }
        System.out.println(" ");
        System.out.println("reduce");
        Iterator<String> it4 = states.iterator();
        MyIterator iter4 = MyIterator.fromIterator(it4);
        BiFunction<String, String, String> func = (x, y) -> x + y;
        System.out.println(iter4.reduce(func));
    }
}
