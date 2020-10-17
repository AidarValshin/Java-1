package main.ru.mephi.java.part6.task7;

public class Pair<E> {
    private E v1;
    private E v2;

    public Pair(E v1, E v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public E get1() {
        return v1;
    }

    public E get2() {
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
