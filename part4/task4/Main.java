package ru.mephi.java.part4.task4;
//Define an abstract class Shape with an instance variable of class Point, a
//constructor, a concrete method public void moveBy(double dx,
//double dy) that moves the point by the given amount, and an abstract method
//public Point getCenter(). Provide concrete subclasses Circle,
//Rectangle, Line with constructors public Circle(Point center,
//double radius), public Rectangle(Point topLeft, double
//width, double height) and public Line(Point from, Point
//to).

public class Main {
    public static void main(String[] args) {
        //Circle
        Shape circle = new Circle(new Point(1, 2), 2);
        System.out.println("circle");
        System.out.println(circle.getCenter());
        circle.moveBy(1, 1);
        System.out.println(circle.getCenter());

        //Rectangle
        Shape rectangle = new Rectangle(new Point(2, 2), 4, 2);
        System.out.println("Rectangle");
        System.out.println(rectangle.getCenter());
        rectangle.moveBy(1, 1);
        System.out.println(rectangle.getCenter());

        //Line
        Shape line = new Line(new Point(1, 1), new Point(3, 3));
        System.out.println("Line");
        System.out.println(line.getCenter());
        line.moveBy(1, 1);
        System.out.println(line.getCenter());

    }
}

