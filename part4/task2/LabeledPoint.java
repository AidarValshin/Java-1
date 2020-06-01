package ru.mephi.java.part4.task2;

public class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    @Override
    public String toString() {
        return " LabeledPoint [ label = "+ label+ ", toString() = "+super.toString()+ "] ";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this== null){
            return false;
        }
        if(!super.equals(otherObject)){
            return false;
        }
        LabeledPoint other = (LabeledPoint) otherObject;
        return label.equals(other.label);
    }

    @Override
    public int hashCode() {
        int tmp =0;
        int length=label.length();
        if(length!=0){
            for (int i=0;i<length; i++)
                tmp=tmp*31 + (label.codePointAt(i));
        }
        int result = super.hashCode();
        result = 31 * result +tmp ^ (tmp >>> 16);
        return result;
    }
}
