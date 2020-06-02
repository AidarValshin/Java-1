package ru.mephi.java.part2.task5;

//Implement an immutable class Point that describes a point in the plane. Provide a
//constructor to set it to a specific point, a no-arg constructor to set it to the origin, and
//methods getX, getY, translate, and scale. The translate method moves
//the point by a given amount in x- and y-direction. The scale method scales both
//coordinates by a given factor. Implement these methods so that they return new
//points with the results. For example,
//Click here to view code image
//Point p = new Point(3, 4).translate(1, 3).scale(0.5);
//should set p to a point with coordinates (2, 3.5).
public class PointClass {
    public static void main(String[] args) {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5f);
        System.out.println(p.getX() + " " + p.getY());
    }
}

class Point {
    private float x;
    private float y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Point translate(float x, float y) {
        Point p = new Point(this.x + x, this.y + y);
        return p;
    }

    public Point scale(float scale) {
        Point p = new Point(this.x * scale, this.y * scale);
        return p;
    }

}
