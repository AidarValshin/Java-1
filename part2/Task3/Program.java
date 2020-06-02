package ru.mephi.java.part2.task3;

public class Program {
    public static void main(String[] args) {
        Mutators m = new Mutators(1);
        int[] a = new int[1];
        m.accessorMethod(a);
        System.out.println(a[0]);
        System.out.println(m.mutatorMethod(3));
        m.accessorMethod(a);
        System.out.println(a[0]);

    }
}
