package main.ru.mephi.java.part7.task10;

public class Neighboor implements  Comparable<Neighboor>{
private String name;
private int lengths;

    public Neighboor(String name, int lengths) {
        this.name = name;
        this.lengths = lengths;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLengths() {
        return lengths;
    }

    public void setLengths(int lengths) {
        this.lengths = lengths;
    }

    @Override
    public int compareTo(Neighboor neighboor) {
      return Integer.compare(this.lengths,neighboor.lengths);
    }
}
