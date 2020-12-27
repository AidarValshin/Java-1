package main.ru.mephi.java.part7.task16;

import main.ru.mephi.java.part7.task13.Cache;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
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
            if (upperBound < shift || upperBound < 0 || shift < 0) {
                throw new IllegalArgumentException();
            }
            this.intFunction = intFunction;
            this.upperBound = upperBound;
            this.shift = shift;
        }


        @Override
        public int size() {
            return upperBound + 1 - shift;
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
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
        public void forEach(Consumer<? super T> action) {
            for (int i = shift; i <= upperBound; i++) {
                action.accept(getAppliedOrSetCash(i));
            }
        }

        @Override
        public Object[] toArray() {
            @SuppressWarnings("unchecked")
            Object[] array = (Object[]) Array.newInstance(
                    getAppliedOrSetCash(0).getClass(),
                    size());
            int j = 0;
            for (int i = this.shift; i <= upperBound; i++) {
                array[j++] = getAppliedOrSetCash(i);
            }
            return array;
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            Object[] array;
            if (ts.length < size()) {
                array = (Object[]) Array.newInstance(ts.getClass().getComponentType(),
                        size());
            } else {
                array = (Object[]) Array.newInstance(ts.getClass().getComponentType(),
                        ts.length);
            }
            int j = 0;
            for (int i = shift; i <= upperBound; i++) {
                array[j++] = getAppliedOrSetCash(i);
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
            if (i < 0 || i > size()) {
                throw new IndexOutOfBoundsException("index = " + i);
            }
            return new ListIterator<T>() {
                private int current = shift - 1 + i;

                @Override
                public boolean hasNext() {
                    return this.current < upperBound;
                }

                @Override
                public T next() {
                    if (hasNext()) {
                        return getAppliedOrSetCash(++current);
                    }
                    throw new IndexOutOfBoundsException("out of bound");
                }


                @Override
                public boolean hasPrevious() {
                    return current > shift - 1;
                }

                @Override
                public T previous() {
                    if (hasPrevious()) {
                        return getAppliedOrSetCash(current--);
                    }
                    throw new IndexOutOfBoundsException("out of bound");

                }

                @Override
                public int nextIndex() {
                    return current == upperBound ? current - shift + 1 : current + 1 - shift;
                }

                @Override
                public int previousIndex() {
                    return current == shift - 1 ? -1 : current - shift;
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
                    || to > size()
                    || from < 0) {
                throw new IllegalArgumentException("wrong bounds from: " + from + " to: " + to);
            }
            return new ImmutableListView<>(shift + from, to + shift - 1, intFunction);
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
        List<String> strings = immutableListView.subList(10, 20);
        System.out.println(Arrays.toString(strings.toArray()));
        System.out.println("---------------------------------------------------------");
        String[] str = new String[20];
        System.out.println(Arrays.toString(strings.toArray(str)));
        System.out.println("---------------------------------------------------------");
        immutableListView.forEach(System.out::println);
        immutableListView.add("3");

    }
}


