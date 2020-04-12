package ru.mephi.java.part2.task4;


public class SwitcInt<publiс> {

    //integer is immutable.  a+=3 means a is a new pointer.


    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        IntHolder a = new IntHolder();
        IntHolder b = new IntHolder();
        a.value = x;
        b.value = y;
        System.out.println(" a " + a.value + " b " + b.value);
        swap(a, b);
        System.out.println(" a " + a.value + " b " + b.value);
    }

    public static void swap(IntHolder a, IntHolder b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
}

