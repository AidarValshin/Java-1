package ru.mephi.java.part4.task5;

public class Line extends Shape {
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

    @Override
    public Line clone() {
        return new Line(this.from, this.to);
    }
}
