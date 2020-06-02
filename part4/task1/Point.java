package ru.mephi.java.part4.task1;

//Define a class Point with a constructor public Point(double x,
//double y) and accessor methods getX, getY. Define a subclass
//LabeledPoint with a constructor public LabeledPoint(String
//label, double x, double y) and an accessor method getLabel.
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
}


