package ru.mephi.java.part2.binaryHeap;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            arr.add(i*i);
        }
        System.out.println(arr);
        BinaryHeap heap = new BinaryHeap(arr);
        System.out.println("max " + heap.getMax());
        System.out.println("size " +heap.getSize());
        System.out.println("max " +heap.getMax());
        System.out.println("size " +heap.getSize());
        heap.add(100);
        System.out.println("add 100");
        heap.add(120);
        System.out.println("add 120");
        System.out.println("max " +heap.getMax());
        System.out.println("size " +heap.getSize());
        System.out.println("max " +heap.getMax());
        System.out.println("size " +heap.getSize());
        System.out.println("max " +heap.getMax());
        System.out.println("size " +heap.getSize());
        System.out.println("arr1 ");
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i = 9; i >-1; i--) {
            arr1.add(i*i);
        }
        System.out.println(arr1);
        BinaryHeap heap1 = new BinaryHeap(arr1);
        while(heap1.getSize()!=0) {
            System.out.println("max " +heap1.getMax());
        }
       /* System.out.println(heap.getSize());
        System.out.println(arr.size());
        heap.add(12);
        System.out.println(heap.getMax());
        System.out.println(heap.getSize());
        ArrayList<Integer> arr1= new ArrayList<>();
        arr1 = BinaryHeap.heapSort(arr);
        System.out.println(arr1);
        */

    }
}

