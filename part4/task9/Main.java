package ru.mephi.java.part4.task9;


import ru.mephi.java.part4.task5.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Shape circle = new Circle(new Point(1, 2), 2);
        System.out.println(UniversalToString.toString(circle));

        //Rectangle
        Shape rectangle = new Rectangle(new Point(2, 2), 4, 2);
        System.out.println(UniversalToString.toString(rectangle));

        //Line
        Shape line = new Line(new Point(1, 1), new Point(3, 3));
        System.out.println(UniversalToString.toString(line));

    }
}

