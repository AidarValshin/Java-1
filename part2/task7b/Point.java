package ru.mephi.java.part2.task7b;

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
    public void translate(float x, float y) {
        this.x += x;
        this.y += y;
    }

    /**
     * Масштабирует
     *
     * @return новая точка
     */
    public void scale(float scale) {
        this.x = this.x * scale;
        this.y = this.y * scale;
    }

}

