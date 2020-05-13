package ru.mephi.java.part4.task4;

public abstract class Shape {
    protected Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        this.point.x += dx;
        this.point.y += dy;
    }

    public abstract Point getCenter();
}

class Circle extends Shape {
    private final double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return this.point;
    }
}

class Rectangle extends Shape {
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
}

class Line extends Shape {
    private Point from;
    private Point to;

    public Line(Point from, Point to) {
        super(null);
        this.from = from;
        this.to = to;
        double centerX = (this.from.getX() + this.to.getX()) / 2;
        double centerY = (this.from.getY() + this.to.getY()) / 2;
        this.point = new Point(centerX, centerY);
    }

    @Override
    public Point getCenter() {
        return this.point;
    }

    @Override
    public void moveBy(double dx, double dy) {
        super.moveBy(dx, dy);
        this.from.x += dx;
        this.from.y += dy;
        this.to.x += dx;
        this.to.y += dy;
    }
}


