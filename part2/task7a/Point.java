package ru.mephi.java.part2.task7a;

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

    /**
     * Перемещает по оси на величины х и у.
     *
     * @return новая точка
     */
    public Point translate(float x, float y) {
        Point p = new Point(this.x + x, this.y + y);
        return p;
    }

    /**
     * Масштабирует
     *
     * @return новая точка
     */
    public Point scale(float scale) {
        Point p = new Point(this.x * scale, this.y * scale);
        return p;
    }
}
