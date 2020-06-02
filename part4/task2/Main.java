package ru.mephi.java.part4.task2;


public class Main {
    public static void main(String[] args) {
        Point p = new Point(2, 3);
        System.out.println(p.getX() + " " + p.getY());
        // toString
        System.out.println(p);
        // equals
        Point p1 = new Point(2, 3);
        Point p2 = new Point(4, 3);
        System.out.println(p + " == " + p1 + " " + p.equals(p1));
        System.out.println(p + " == " + p2 + " " + p.equals(p2));
        // hashCode
        System.out.println(p.hashCode());
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        LabeledPoint lP = new LabeledPoint("first", 4, 5);
        System.out.println(lP.getLabel() + " " + lP.getX() + " " + lP.getY());
        // toString
        System.out.println(lP);
        // equals
        LabeledPoint lP1 = new LabeledPoint("first", 4, 5);
        LabeledPoint lP2 = new LabeledPoint("second", 4, 5);
        System.out.println(lP + " == " + lP1 + " " + lP.equals(lP1));
        System.out.println(lP + " == " + lP2 + " " + lP.equals(lP2));
        // hashCode
        System.out.println(lP.hashCode());
        System.out.println(lP1.hashCode());
        System.out.println(lP2.hashCode());


    }
}

