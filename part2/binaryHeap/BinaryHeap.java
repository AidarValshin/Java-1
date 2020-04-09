package ru.mephi.java.part2.binaryHeap;

import java.util.ArrayList;

public class BinaryHeap {
    private ArrayList<Integer> arr = new ArrayList();

    //О(N)
    BinaryHeap(ArrayList<Integer> newArr) {
        arr = (ArrayList<Integer>) newArr.clone();
        int size = arr.size();
        for (int i = size / 2; i >= 0; i--) {
            heapRecover(i);
        }
    }

    public int getSize() {
        return arr.size();
    }

    public void recoverAdd(int i) {
        int parent = (i - 1) / 2;
        while (i > 0 && (arr.get(i) > arr.get(parent))) {
            int temp = arr.get(i);
            arr.set(i, arr.get(parent));
            arr.set(parent, temp);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    //O(log2 N)
    public void add(int item) {
        int size = arr.size();
        arr.add( item);
        recoverAdd(size);
    }

    //O(log2 N)
    public void heapRecover(int i) {
        int leftChild;
        int rightChild;
        int parent;
        int size = arr.size();
        for (; ; ) {
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            parent = i;

            if (leftChild < size && (arr.get(leftChild) > arr.get(parent))) {
                parent = leftChild;
            }

            if (rightChild < size && (arr.get(rightChild) > arr.get(parent))) {
                parent = rightChild;
            }

            if (parent == i) {
                break;
            }

            int temp = arr.get(i);
            arr.set(i, arr.get(parent));
            arr.set(parent, temp);
            i = parent;
        }
    }

    //O(log2 N)
    public int getMax() {
        int result = arr.get(0);
        int size =arr.size();
        if(size!=1) {
            int tmp = arr.remove(size - 1);
            arr.set(0, tmp);
        }
        else
        {
            arr.remove(0);
        }
        size = arr.size();

       /* for (int i = size / 2; i >= 0; i--) {
            heapRecover(i);
        }
                */
        heapRecover(0);
        return result;
    }

    //O(N log2 N) по убыванию
    public static ArrayList<Integer> heapSort(ArrayList<Integer> arr) {
        BinaryHeap heap = new BinaryHeap(arr);
        int size = arr.size();
        ArrayList<Integer> arr1 =new ArrayList(size);
        for (int i = 0; i <size; i++) {
            arr1.add( heap.getMax());
            heap.heapRecover(0);
        }
        return arr1;
    }
}
