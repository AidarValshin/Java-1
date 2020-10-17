package main.ru.mephi.java.part6.task2;

import java.util.Arrays;

class StackO<E> {
    private Object[] array;
    private int fill = 0;

    public StackO() {
        array = new Object[5];
    }

    public StackO(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("size must be > 0");
        }
        array = new Object[initialCapacity];
    }


    public void push(E e) {
        if (fill == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
        array[fill++] = e;
    }

    public E pop() {
        return (E) array[fill--];
    }

    public boolean isEmpty() {
        return fill == 0;
    }
}
