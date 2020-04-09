package ru.mephi.java.part2.task17;

public class Program {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add("A");
        q.add("B");
        q.print();
        q.add("C");
        System.out.println(q.remove());
        System.out.println("  ");
        q.print();
        Queue.Iterator iterator = q.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
