package main.ru.mephi.java.part6.task1;

import java.util.ArrayList;

public class Stack<E> {
    private ArrayList<E> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.isEmpty());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.isEmpty());
    }

    public void push(E e) {
        arrayList.add(e);
    }

    public E pop() {
        return arrayList.remove(arrayList.size() - 1);
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
}
