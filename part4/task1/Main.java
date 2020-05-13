package ru.mephi.java.part4.task1;


public class Main {
    public static void main(String[] args) {
        Point p = new Point(2, 3);
        System.out.println(p.getX() + " " + p.getY());

        LabeledPoint lP = new LabeledPoint("first", 4, 5);
        System.out.println(lP.getLabel() + " " + lP.getX() + " " +lP.getY());

        Point lP2 = new LabeledPoint("second", 5, 3);
        System.out.println(((LabeledPoint) lP2).getLabel() + " " + lP2.getX() + " " + lP2.getY());

    }
}

