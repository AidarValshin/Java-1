package ru.mephi.java.part4.task9;

import ru.mephi.java.part4.task5.Circle;
import ru.mephi.java.part4.task5.Point;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Circle circle = new Circle(new Point(1, 2), 2);

        AdditionalClasses a = new AdditionalClasses();
        a.c = circle;
        a.next = new AdditionalClasses();
        a.next.c = new Circle(new Point(2, 2), 3);
        a.next.next = new AdditionalClasses();
        a.next.next.c = circle;
        a.next.next.next = a;

        System.out.println(UniversalToString.toString(a));
    }
}

