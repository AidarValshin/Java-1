package main.ru.mephi.java.part7.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ConcurrentModificationException {
    public static <E> void getException(List<E> list, E target) {
        ListIterator<E> listIterator=list.listIterator();
        list.removeIf(e -> e.equals(target));
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());// throws ConcurrentModificationException
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0;i<10;i++){
            arrayList.add(i);
        }
        getException(arrayList,2);
    }

}
