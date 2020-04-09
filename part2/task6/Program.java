package ru.mephi.java.part2.task6;

public class Program {
    public static void main(String[] args) {
        Point p = new Point(3, 4);
        p.translate(1, 3);
        p.scale(0.5f);
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

    public void translate(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void scale(float scale) {
        this.x = this.x * scale;
        this.y = this.y * scale;
    }

}
