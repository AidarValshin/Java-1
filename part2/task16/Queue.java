package ru.mephi.java.part2.task16;
//Implement a class Queue, an unbounded queue of strings. Provide methods add,
//adding at the tail, and remove, removing at the head of the queue. Store elements
//as a linked list of nodes. Make Node a nested class. Should it be static or not?

import java.util.LinkedList;

// nested class should be static,because he doesnt need to know about its owner
public class Queue {
    private LinkedList<Node> queue = new LinkedList<>();

    private static class Node {
        String str;

        Node(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }

    public void add(String str) {
        queue.add(new Node(str));
    }

    public String remove() {
        return queue.remove().getStr();
    }

    public void print() {
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.get(i).getStr());
        }
        System.out.println(" ");
    }
}
