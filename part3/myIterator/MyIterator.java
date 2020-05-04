package ru.mephi.java.part3.myIterator;

import java.util.Iterator;
import java.util.function.BiFunction;

public class MyIterator {
    private Iterator<String> iter;
    private MyIterator otherIter;
    private int currentIter;


    private MyIterator(Iterator<String> iter) {
        this.iter = iter;
        this.otherIter = null;
        this.currentIter = 0;
    }

    public boolean hasNext() {
        if (otherIter == null) {
            return iter.hasNext();
        } else {
            if (currentIter == 0) {
                boolean res = iter.hasNext();
                if (!res) {
                    currentIter = 1;
                }
            }
            return (currentIter == 0) || otherIter.hasNext();
        }
    }

    public String next() {

        if (otherIter == null) {
            return iter.next();
        } else {
            return (currentIter == 0) ? iter.next() : otherIter.next();
        }
    }


    public static MyIterator fromIterator(Iterator<String> iter) {
        return new MyIterator(iter);
    }

    public MyIterator union(MyIterator otherIter) { // переделать на pipeline
        MyIterator tmp = this;
        while (tmp.otherIter != null) {
            tmp = tmp.otherIter;
        }
        tmp.otherIter = otherIter;
        return this;
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