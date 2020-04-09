package ru.mephi.java.part1;

public class HelloWorld {
    public  static void main(String[] args) {
        String s= "HelloWorld";
        int l= s.length();
        System.out.println(s+ '\n' +"len = " + l);
        byte b = 127;
        b++;
        System.out.println(b);
        String str = Double.toHexString(25);
        System.out.println(str);
    }
}
