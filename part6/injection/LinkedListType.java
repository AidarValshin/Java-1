package main.ru.mephi.java.part6.injection;


/**
 * upLow true if Upper bound, false if is lower
 * strict true if it is strict bound.
 * level=-10 is  for parent class
 */
public class LinkedListType {
    private String type;
    private boolean upLow; // upper - true,lower - false
    private boolean strict;
    private int level;
    private LinkedListType next;

    public LinkedListType(String type, boolean upLow, boolean strict) {
        this.type = type;
        this.upLow = upLow;
        this.level = 0;
        this.next = null;
        this.strict = strict;
    }

    private LinkedListType(String type, boolean upLow, int level) {
        this.type = type;
        this.upLow = upLow;
        this.level = level;
        this.next = null;
        this.strict = false;
    }

    private LinkedListType(String type, boolean upLow, int level, boolean strict) {
        this.type = type;
        this.upLow = upLow;
        this.level = level;
        this.next = null;
        this.strict = strict;
    }

    public LinkedListType setNext(String type, boolean upLow) {
        this.next = new LinkedListType(type, upLow, this.level + 1);
        return this.next;
    }

    public static LinkedListType setInitalParent(String type) {
        return new LinkedListType(type, true, -10, false);
    }

    public String getType() {
        return type;
    }

    /**
     * @return true if Upper bound, false if is lower
     */
    public boolean isUpLow() {
        return upLow;
    }

    public int getLevel() {
        return level;
    }

    public LinkedListType getNext() {
        return next;
    }

    /**
     * @return true if strict generic
     */
    public boolean isStrict() {
        return strict;
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    @Override
    public String toString() {
        return "LinkedListType{" +
                "type='" + type + '\'' +
                ", upLow=" + upLow +
                ", strict=" + strict +
                ", level=" + level +
                ", next=" + next +
                '}';
    }
}
