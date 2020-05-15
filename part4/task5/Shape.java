package ru.mephi.java.part4.task5;

public abstract class Shape implements Cloneable {
    protected Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        this.point.x += dx;
        this.point.y += dy;
    }

    @Override
    public abstract Shape clone();

    public abstract Point getCenter();
}


