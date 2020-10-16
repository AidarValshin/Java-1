package main.ru.mephi.java.part6.task2;

public class Main {
    public static void main(String[] args) {
        StackE<Integer> stack = new StackE<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.isEmpty());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("Is empty? "+stack.isEmpty());
        System.out.println();

        StackO<Integer> stackO = new StackO<>();
        stackO.push(1);
        stackO.push(2);
        stackO.push(3);
        System.out.println(stackO.isEmpty());
        while (!stackO.isEmpty()) {
            System.out.println(stackO.pop());
        }
        System.out.println("Is empty? "+stackO.isEmpty());
    }
}
