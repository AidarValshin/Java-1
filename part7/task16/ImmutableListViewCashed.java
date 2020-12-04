package main.ru.mephi.java.part7.task16;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.function.IntFunction;

public class ImmutableListViewCashed {
    private int current=0;
    private IntFunction<Integer> intFunction ;

    public ImmutableListViewCashed( IntFunction<Integer> func) {
        this.intFunction = func;
    }
    private   Iterator<Integer> immutableListView = new Iterator<>() {
            @Override
            public boolean hasNext() {
                return current < intFunction.apply(current);
            }
            @Override
            public Integer next() {
                if (hasNext()) {
                    current=intFunction.apply(current);
                    cash.add(current);
                    if(cash.size()>100){
                        cash.remove();
                    }
                    return current;
                }
                throw new IndexOutOfBoundsException("out of bound");
            }
        };
    private ArrayDeque<Integer> cash = new ArrayDeque<>() ;

    public Iterator<Integer> getImmutableListView() {
        return immutableListView;
    }

    public ArrayDeque<Integer> getCash() {
        return cash;
    }

    public static void main(String[] args) {
        ImmutableListViewCashed immutableListViewCashed = new ImmutableListViewCashed(p->p<120? ++p:p);
        Iterator<Integer> iterator = immutableListViewCashed.getImmutableListView();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("cache");
        ArrayDeque<Integer> cache=immutableListViewCashed.getCash();
        System.out.println("first: "+cache.peek());

        System.out.println("last: "+cache.descendingIterator().next());
    }
}

