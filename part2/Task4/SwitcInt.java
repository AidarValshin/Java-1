package ru.mephi.java.part2.task4;

//Why can’t you implement a Java method that swaps the contents of two int
//variables? Instead, write a method that swaps the contents of two IntHolder
//objects. (Look up this rather obscure class in the API documentation.) Can you swap
//the contents of two Integer objects?
public class SwitcInt {
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

