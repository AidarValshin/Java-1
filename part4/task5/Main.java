package ru.mephi.java.part4.task5;


public class Main {
    public static void main(String[] args) {
        //Circle
        Shape circle = new Circle(new Point(1, 2), 2);
        System.out.println("circle");
        System.out.println(circle.getCenter());
        circle.moveBy(1, 1);
        System.out.println(circle.getCenter());
        System.out.println("Clone");
        Shape circle1 = circle.clone();
        System.out.println(circle.getCenter());
        System.out.println(circle1.getCenter());

        //Rectangle
        Shape rectangle = new Rectangle(new Point(2, 2), 4, 2);
        System.out.println("Rectangle");
        System.out.println(rectangle.getCenter());
        rectangle.moveBy(1, 1);
        System.out.println(rectangle.getCenter());
        System.out.println("Clone");
        Shape rectangle1 = rectangle.clone();
        System.out.println(rectangle.getCenter());
        System.out.println(rectangle1.getCenter());

        //Line
        Shape line = new Line(new Point(1, 1), new Point(3, 3));
        System.out.println("Line");
        System.out.println(line.getCenter());
        line.moveBy(1, 1);
        System.out.println(line.getCenter());
        System.out.println("Clone");
        Shape line1 = line.clone();
        System.out.println(line.getCenter());
        System.out.println(line1.getCenter());
    }
}

