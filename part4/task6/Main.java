package ru.mephi.java.part4.task6;

public class Main {
    public static void main(String[] args) {
        Item i1 = new DiscountedItem("a", 10, 1);
        Item i2 = new Item("a", 10);
        Item i3 = new DiscountedItem("a", 10, 2);
        System.out.println(" symmetric ");
        System.out.println(" i1.equals(i2) " + i1.equals(i2));
        System.out.println(" i2.equals(i1) " + i2.equals(i1));
        System.out.println(" i2.equals(i3) " + i2.equals(i3));
        System.out.println(" i3.equals(i2) " + i3.equals(i2));
        System.out.println(" transitive ");
        System.out.println(" i1.equals(i2) " + i1.equals(i2));
        System.out.println(" i2.equals(i3) " + i2.equals(i3));
        System.out.println(" i1.equals(i3) " + i1.equals(i3));
    }
}

