package ru.mephi.java.part4.task8;


public class Circle {
    Point center;
    double radius;

    public Circle(double x, double y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    public Point getPoint() {
        return center;
    }

    public class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
