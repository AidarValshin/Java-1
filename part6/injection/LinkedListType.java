package main.ru.mephi.java.part6.injection;


/**
 * upLow true if Upper bound, false if is lower
 * level=-10 is  for parent class
 */
public class LinkedListType {
    private String type;
    private boolean upLow; // upper - true,lower - false
    private int level;
    private LinkedListType next;

    public LinkedListType(String type, boolean upLow) {
        this.type = type;
        this.upLow = upLow;
        this.level = 0;
        this.next = null;
    }
    private LinkedListType(String type, boolean upLow, int level) {
        this.type = type;
        this.upLow = upLow;
        this.level = level;
        this.next = null;
    }

    public LinkedListType setNext(String type, boolean upLow){
        this.next=new LinkedListType(type,upLow,this.level+1);
        return this.next;
    }
    public static LinkedListType setInitalParent(String type){
        return new LinkedListType(type,true,-10);
    }
    public String getType() {
        return type;
    }

    /**
     *
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

    @Override
    public String toString() {
        return "LinkedListType{" +
                "type='" + type + '\'' +
                ", upLow=" + upLow +
                ", level=" + level +
                ", next=" + next +
                '}';
    }
}
