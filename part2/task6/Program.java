package ru.mephi.java.part2.task6;

public class Program {
    public static void main(String[] args) {
        Point p = new Point(3, 4);
        p.translate(1, 3);
        p.scale(0.5f);
        System.out.println(p.getX() + " " + p.getY());
    }
}

