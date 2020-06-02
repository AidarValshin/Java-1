package ru.mephi.java.part2.task6;

//Repeat the preceding exercise, but now make translate and scale into mutators.
public class Point {
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
