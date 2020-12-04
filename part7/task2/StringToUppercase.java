package main.ru.mephi.java.part7.task2;

import java.util.ArrayList;
import java.util.ListIterator;

public class StringToUppercase {
    public static ArrayList<String> doOverIterator(ArrayList<String> arrayList) {
        String next;
        for (ListIterator<String> iter = arrayList.listIterator(); iter.hasNext(); ) {
            next = iter.next();
            next = next.toUpperCase();
            iter.set(next);
        }
        return arrayList;
    }

    public static ArrayList<String> doOverIndexes(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, arrayList.get(i).toUpperCase());
        }
        return arrayList;
    }

    public static ArrayList<String> doOverReplaceAll(ArrayList<String> arrayList) {
        arrayList.replaceAll(String::toUpperCase);
        return arrayList;
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aAa ");
        arrayList.add("bBb ");
        arrayList.add("zZz ");
        doOverIterator(arrayList).forEach(System.out::print);
        System.out.println();
        arrayList = new ArrayList<>();
        arrayList.add("aAa ");
        arrayList.add("bBb ");
        arrayList.add("zZz ");
        doOverIndexes(arrayList).forEach(System.out::print);
        System.out.println();
        arrayList = new ArrayList<>();
        arrayList.add("aAa ");
        arrayList.add("bBb ");
        arrayList.add("zZz ");
        doOverReplaceAll(arrayList).forEach(System.out::print);
        System.out.println();
    }
}
