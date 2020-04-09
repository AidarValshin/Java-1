package ru.mephi.java.part2.Task4;

import    jdk.nashorn.internal.runtime.regexp.joni.encoding.IntHolder ;

public class SwitcInt {
    /*
    integer is immutable.  a+=3 means a is a new pointer.
    
     */
    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        IntHolder a = new IntHolder();
        IntHolder b = new IntHolder();
        a.value=x;
        b.value=y;
        swap(a, b);
        int p = a.value;
        int q = b.value;
        System.out.println("x"+x+"y"+y);
    }
       static  void swap (IntHolder a, IntHolder b){
            int temp = a.value;
            a.value = b.value;
            b.value = temp;
        }
    }

