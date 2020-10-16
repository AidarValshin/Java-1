package main.ru.mephi.java.part6.task2;

import java.util.ArrayList;
import java.util.Arrays;


  public class StackE<E> {
       private E[] array;
       private int fill = 0;

       @SuppressWarnings("unchecked")
       public StackE() {
           array = (E[]) new Object[5];
       }

       @SuppressWarnings("unchecked")
       public StackE(int initialCapacity) {
           if (initialCapacity <= 0) {
               throw new IllegalArgumentException("size must be > 0");
           }
           array = (E[]) new Object[initialCapacity];
       }


       public void push(E e) {
           if (fill == array.length) {
               array = Arrays.copyOf(array, (int) (array.length * 1.5));
           }
           array[fill++] = e;
       }

       public E pop() {
           return array[fill--];
       }

       public boolean isEmpty() {
           return fill == 0;
       }
   }

