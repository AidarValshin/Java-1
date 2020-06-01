package ru.mephi.java.part4.task3.classes.labeled;

import ru.mephi.java.part4.task3.classes.point.Point;

public class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public String getAttributes() {
        return "label = " + this.label + "  " + ", x = " + x + ", y = " + y;
    }


}
