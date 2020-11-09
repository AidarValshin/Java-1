package main.ru.mephi.java.part6.Additionally;

public class Pair<L,R extends Number> {
    private L v1; //Object
    private R v2;//Number

    public Pair(L v1, R v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public L get1() {
        return v1;
    }

    public R get2() {
        return v2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                '}';
    }



}
