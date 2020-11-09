package main.ru.mephi.java.part6.Additionally;

import java.util.List;
import java.util.Map;

public class Pair1<L, R extends Number> {
    private Object v1; //Object
    private Number v2;//Number

    public Pair1(Object v1, Number v2) { // L Object  R - Number
        this.v1 = v1;
        this.v2 = v2;
    }

    public Object get1() {
        return v1;
    }//Object

    public Number get2() {
        return v2;
    }//Number

    @Override
    public String toString() {
        return "Pair{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                '}';
    }

    // public Map<L,R> method (List<R> list)
    public Map method(List list) { // L Object  R - Number
        return null;
    }
}
