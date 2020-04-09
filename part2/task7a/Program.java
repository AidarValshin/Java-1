package ru.mephi.java.part2.task7a;


public class Program {
    public static void main(String[] args) {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5f);
        System.out.println(p.getX() + " " + p.getY());
    }
}
