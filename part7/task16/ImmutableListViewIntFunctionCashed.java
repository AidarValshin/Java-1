package main.ru.mephi.java.part7.task16;

import main.ru.mephi.java.part7.task13.Cache;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntFunction;

public class ImmutableListViewIntFunctionCashed {
    public static <T> ImmutableListView<T> getImmutableListView(int i, IntFunction<T> intFunction) {
        return new ImmutableListView<T>(i, intFunction);
    }

    private static class ImmutableListView<T> implements List<T> {
        private final int upperBound;
        private final int shift;
        private IntFunction<T> intFunction;
        private Map<Integer, T> cash = new Cache<>(100);

        private T getAppliedOrSetCash(int index) {
            if (cash.containsKey(index)) {
                System.out.println("get");
                return cash.get(index);
            } else {
                T result = intFunction.apply(index);
                cash.put(index, result);
                System.out.println("put or replace");

                return result;
            }
        }

        public ImmutableListView(int upperBound, IntFunction<T> intFunction) {
            this.intFunction = intFunction;
            if (upperBound < 0) {
                throw new IllegalArgumentException(upperBound + "<0");
            }
            this.upperBound = upperBound;
            this.shift = 0;
        }

        public ImmutableListView(int shift, int upperBound, IntFunction<T> intFunction) {
            this.intFunction = intFunction;
            if (upperBound < shift || upperBound < 0 || shift < 0) {
                throw new IllegalArgumentException();
            }
            this.upperBound = upperBound;
            this.shift = shift;
        }


        @Override
        public int size() {
            return upperBound + 1 - shift;
        }

        @Override
        public boolean isEmpty() {
            return upperBound + 1 - shift > 0;
        }

        @Override
        public boolean contains(Object o) {
            for (int i = shift; i <= upperBound; i++) {
                if (getAppliedOrSetCash(i).equals(o)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override
        public Object[] toArray() {

            @SuppressWarnings("unchecked")
            T[] array = (T[]) Array.newInstance(
                    intFunction.apply(0).getClass(),
                    upperBound - shift + 1);
            int j = 0;
            for (int i = this.shift; i <= upperBound; i++) {
                array[j++] = getAppliedOrSetCash(i);
            }
            return array;
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            Object[] array = null;
            int j = 0;
            if (ts.length < this.upperBound - shift + 1) {
                array = (Object[]) Array.newInstance(ts.getClass().getComponentType(), upperBound - shift + 1);
                for (int i = this.shift; i <= upperBound; i++) {
                    array[j++] = getAppliedOrSetCash(i);
                }
            } else {
                array = (Object[]) Array.newInstance(ts.getClass().getComponentType(), ts.length);
                for (int i = this.shift; i <= upperBound; i++) {
                    array[j++] = getAppliedOrSetCash(i);
                }
                for (int i = upperBound + 1; i < ts.length; i++) {
                    array[j++] = null;
                }
            }
            return (T[]) array;
        }

        @Override
        public boolean add(T t) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            for (Object o : collection) {
                if (!contains(o)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends T> collection) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public boolean addAll(int i, Collection<? extends T> collection) {
            throw new UnsupportedOperationException("Cant change view");
        }


        @Override
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public T get(int i) {
            if (i + shift <= upperBound && i >= 0) {
                return getAppliedOrSetCash(i + shift);
            }
            throw new IndexOutOfBoundsException(" your index is: " + i + ", bound is: " + (upperBound - shift));
        }


        @Override
        public T set(int i, T t) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public void add(int i, T t) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public T remove(int i) {
            throw new UnsupportedOperationException("Cant change view");
        }


        @Override
        public int indexOf(Object o) {
            for (int i = shift; i <= upperBound; i++) {
                if (getAppliedOrSetCash(i).equals(o)) {
                    return i - shift;
                }
            }

            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            int index = -1;
            for (int i = shift; i <= upperBound; i++) {
                if (getAppliedOrSetCash(i).equals(o)) {
                    index = i - shift;
                }
            }
            return index;
        }

        @Override
        public ListIterator<T> listIterator() {
            return listIterator(0);
        }

        @Override
        public ListIterator<T> listIterator(int i) {
            if (i < 0 || i > this.upperBound - this.shift + 1) {
                throw new IndexOutOfBoundsException("index = " + i);
            }
            return new ListIterator<T>() {
                private int current = shift - 1 + i;

                @Override
                public boolean hasNext() {
                    return this.current <= upperBound;
                }

                @Override
                public T next() {
                    if (hasNext()) {
                        return getAppliedOrSetCash(++this.current);
                    }
                    throw new IndexOutOfBoundsException("out of bound");
                }


                @Override
                public boolean hasPrevious() {
                    return current > i;
                }

                @Override
                public T previous() {
                    if (hasPrevious()) {
                        return getAppliedOrSetCash(--current);
                    }
                    throw new IndexOutOfBoundsException("out of bound");

                }

                @Override
                public int nextIndex() {
                    return this.current == upperBound ? this.current : this.current + 1;
                }

                @Override
                public int previousIndex() {
                    return this.current == shift - 1 + i ? -1 : this.current - 1;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("Cant change view");
                }

                @Override
                public void set(T t) {
                    throw new UnsupportedOperationException("Cant change view");
                }

                @Override
                public void add(T t) {
                    throw new UnsupportedOperationException("Cant change view");
                }
            };
        }

        @Override
        public List<T> subList(int from, int to) {
            if (from > to
                    || to > upperBound - shift + 1
                    || from < 0) {
                throw new IllegalArgumentException("wrong bounds from: " + from + " to: " + to);
            }
            return new ImmutableListView<>(this.shift + from, to + shift - 1, intFunction);
        }

    }

    public static void main(String[] args) {
        ImmutableListViewIntFunctionCashed.ImmutableListView<String> immutableListView
                = ImmutableListViewIntFunctionCashed.getImmutableListView(98, p -> Integer.toString(p + 2));
        immutableListView.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        Iterator<String> iterator = immutableListView.iterator();
        for (int i = 0; i < 98; i++) {
            System.out.println(iterator.next());
        }
        //System.out.println(immutableListView.contains(-5));
        //System.out.println(immutableListView.contains(-11));
        System.out.println(Arrays.toString(immutableListView.subList(10, 51).toArray()));
        System.out.println("---------------------------------------------------------");

        immutableListView.add("3");

    }
}


