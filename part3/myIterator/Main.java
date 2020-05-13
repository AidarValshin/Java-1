package ru.mephi.java.part3.myIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BiFunction;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> states = new ArrayList<>();
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Spain");

        ArrayList<String> states1 = new ArrayList<>();
        states1.add("Germany1");
        states1.add("France1");
        states1.add("Italy1");
        states1.add("Spain1");

        ArrayList<String> states2 = new ArrayList<>();
        states2.add("Germany2");
        states2.add("France2");
        states2.add("Italy2");
        states2.add("Spain2");

        Iterator<String> it0 = states.iterator();
        MyIterator iter0 = MyIterator.fromIterator(it0);
        while (iter0.hasNext()) {

            System.out.println(iter0.next());
        }
        System.out.println(" ");
        System.out.println("union");
        Iterator<String> it1 = states.iterator();
        Iterator<String> it2 = states1.iterator();
        Iterator<String> it3 = states2.iterator();
        MyIterator iter3 = MyIterator.fromIterator(it1).union(MyIterator.fromIterator(it2)).union(MyIterator.fromIterator(it3));
        
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
