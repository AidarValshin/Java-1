package main.ru.mephi.java.part7;

import java.util.ArrayList;
import java.util.ListIterator;

public class ћрят {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>(2);
        arrayList.add(1);
        arrayList.add(2);
        ListIterator<Integer> listIterator=arrayList.listIterator(1);
        System.out.println(listIterator.previousIndex()); //0
        System.out.println(listIterator.nextIndex());//1
        System.out.println(listIterator.next());//2
        System.out.println("--------------------");
        System.out.println(listIterator.previousIndex());//1
        System.out.println(listIterator.nextIndex());//2
        System.out.println(listIterator.previous());//2
        System.out.println("--------------------");
        System.out.println(listIterator.previousIndex());//0
        System.out.println(listIterator.nextIndex());//1
        System.out.println(listIterator.previous());//1
        System.out.println("--------------------");
        System.out.println(listIterator.previousIndex());//-1
        System.out.println(listIterator.nextIndex());//0
        System.out.println(listIterator.next());//1
    }
}
