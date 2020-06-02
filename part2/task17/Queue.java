package ru.mephi.java.part2.task17;
//Provide an iterator—an object that yields the elements of the queue in turn—for the
//queue of the preceding class. Make Iterator a nested class with methods next
//and hasNext. Provide a method iterator() of the Queue class that yields a
//Queue.Iterator. Should Iterator be static or not?

import java.util.LinkedList;

// Node class should be static,because he doesnt need to know about its owner
//Iterator non static, he need to know it's owner
public class Queue {
    private LinkedList<Node> queue = new LinkedList<>();

    private static class Node {
        private String str;

        Node(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }
    }

    public class Iterator {
        private int i;

        Iterator() {
            i = -1;
        }

        public boolean hasNext() {
            if ((i + 1) < queue.size()) {
                return true;
            } else {
                return false;
            }
        }

        // bad realization
        public String next() {
            if (hasNext()) {
                i += 1;
                return (queue.get(i).getStr());
            }
            return null;
        }
    }

    public Queue.Iterator iterator() {
        return new Iterator();
    }

    public void add(String str) {
        queue.add(new Queue.Node(str));
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
