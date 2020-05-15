package ru.mephi.java.part4.task5;

public class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
        double x = (2 * this.point.getX() + this.width) / 2;
        double y = (2 * this.point.getY() - this.height) / 2;
        return new Point(x, y);
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(this.point, this.width, this.height);
    }
}
