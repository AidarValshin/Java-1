package ru.mephi.java.part3.myIterator;

import java.util.Iterator;
import java.util.function.BiFunction;

public class MyIterator {
    private Iterator<String> iter;
    private MyIterator iter1;
    private int numbIter;

    private MyIterator(Iterator<String> iter) {
        this(iter, null);
    }

    private MyIterator(Iterator<String> iter, MyIterator iter1) {
        this.iter = iter;
        this.iter1 = iter1;
        this.numbIter = 0;
    }

    public boolean hasNext() {
        if (iter1 == null) {
            return iter.hasNext();
        } else {
            if (numbIter == 0) {
                boolean res = iter.hasNext();
                if (res == false) {
                    numbIter = 1;
                }
            }
            return (numbIter == 0) ? true : iter1.hasNext();
        }
    }

    public String next() {

        if (iter1 == null) {
            return iter.next();
        } else {
            return (numbIter == 0) ? iter.next() : iter1.next();
        }
    }


    public static MyIterator fromIterator(Iterator<String> iter) {
        return new MyIterator(iter);
    }

    public MyIterator union(MyIterator otherIter) {
        return new MyIterator(this.iter, otherIter);
    }

    public String reduce(BiFunction<String, String, String> func) {
        if (this.hasNext()) {
            String result = this.next();
            while (this.hasNext()) {
                result = func.apply(result, this.next());
            }
            return result;
        }
        return null;
    }
}