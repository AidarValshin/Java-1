package ru.mephi.java.part4.task5;

public class Circle extends Shape {
    private final double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return this.point;
    }

    @Override
    public Circle clone() {
        return new Circle(this.point, this.radius);
    }

}
