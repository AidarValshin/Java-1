package ru.mephi.java.part2.addTask;

/**
 * An <code>Point </code> object represents an point with
 * coordinates x and y.
 *
 * @ author Valshin Aidar
 * @ version 1.1
 */
public class Point {
    private float x;
    private float y;
    private float z;

    public Point() {
        this(0, 0, 0);
    }

    public Point(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(float z) {
        this(0, 0, z);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    /**
     * move  х and у.
     *
     * @return new point
     */
    public Point translate(float x, float y) {
        Point p = new Point(this.x + x, this.y + y, this.z + z);
        return p;
    }

    /**
     * Scale
     *
     * @return new point
     */
    public Point scale(float scale) {
        Point p = new Point(this.x * scale, this.y * scale, this.z * scale);
        return p;
    }
}