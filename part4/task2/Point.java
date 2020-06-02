package ru.mephi.java.part4.task2;

//Define toString, equals, and hashCode methods for the classes of the
//preceding exercise.
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return " Point [ x = " + x + ", y = " + y + "] ";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == null) {
            return false;
        }
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Point other = (Point) otherObject;
        return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x) &&
                Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);

    }

    @Override
    public int hashCode() {
        Long tmp = Double.doubleToLongBits(x);
        int result = (int) (tmp ^ (tmp >>> 32));
        tmp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (tmp ^ (tmp >>> 32));
        return result;
    }
}


