package main.ru.mephi.java.part7.task14;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ImmutableListView2 {
    public static ImmutableListView getImmutableListView(int i) {
        return new ImmutableListView(i);
    }

    private static class ImmutableListView implements List<Integer> {
        private final int size;
        private final int lowBound;

        public ImmutableListView(int size) {
            if (size < 0) {
                throw new IllegalArgumentException(size + "<0");
            }
            this.size = size;
            this.lowBound = 0;
        }

        public ImmutableListView(int lowBound, int size) {
            if (size < lowBound || size < 0 || lowBound < 0) {
                throw new IllegalArgumentException();
            }
            this.size = size;
            this.lowBound = lowBound;
        }


        @Override
        public int size() {
            return size + 1;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            if (o instanceof Integer) {
                return (int) o <= size;
            }
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>() {
                private int current = lowBound-1;

                @Override
                public boolean hasNext() {
                    return this.current < size;
                }

                @Override
                public Integer next() {
                    if (this.current > size) {
                        throw new IndexOutOfBoundsException("out of bound");
                    }
                    return ++this.current;
                }
            };
        }

        @Override
        public Object[] toArray() {
            Integer[] array = new Integer[size];
            for (int i = this.lowBound; i <= size; i++) {
                array[i] = i;
            }
            return array;
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            Object[] array = null;
            if (ts.length > this.size) {
                array = (Object[]) Array.newInstance(ts.getClass().getComponentType(), size);
                for (int i = this.lowBound; i <= size; i++) {
                    array[i] = i;
                }
            } else {
                array = (Object[]) Array.newInstance(ts.getClass().getComponentType(), ts.length);
                for (int i = this.lowBound; i < ts.length; i++) {
                    array[i] = i;
                }
                for (int i = ts.length + 1; i <= size; i++) {
                    array[i] = null;
                }
            }
            return (T[]) array;
        }

        @Override
        public boolean add(Integer integer) {
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
            return collection.size() > 0;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> collection) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public boolean addAll(int i, Collection<? extends Integer> collection) {
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
        public Integer get(int i) {
            return i;
        }

        @Override
        public Integer set(int i, Integer integer) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public void add(int i, Integer integer) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public Integer remove(int i) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public int indexOf(Object o) {
            if (o instanceof Integer) {
                int oo = (int) o;
                if (oo <= size) {
                    return oo;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            return indexOf(o);
        }

        @Override
        public ListIterator<Integer> listIterator() {
            return new ListIterator<Integer>() {
                private int current = lowBound-1;

                @Override
                public boolean hasNext() {
                    return this.current < size;
                }

                @Override
                public Integer next() {
                    if (this.current > size) {
                        throw new IndexOutOfBoundsException("out of bound");
                    }
                    return ++this.current;
                }

                @Override
                public boolean hasPrevious() {
                    return current > lowBound;
                }

                @Override
                public Integer previous() {
                    return --current;
                }

                @Override
                public int nextIndex() {
                    return this.current + 1;
                }

                @Override
                public int previousIndex() {
                    return this.current - 1;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("Cant change view");
                }

                @Override
                public void set(Integer integer) {
                    throw new UnsupportedOperationException("Cant change view");
                }

                @Override
                public void add(Integer integer) {
                    throw new UnsupportedOperationException("Cant change view");
                }
            };
        }

        @Override
        public ListIterator<Integer> listIterator(int i) {
            if (i < lowBound || i > this.size) {
                throw new IndexOutOfBoundsException("index = " + i);
            }
            return new ListIterator<Integer>() {
                private int current = i;

                @Override
                public boolean hasNext() {
                    return this.current <= size;
                }

                @Override
                public Integer next() {
                    if (this.current > size) {
                        throw new IndexOutOfBoundsException("out of bound");
                    }
                    return ++this.current;
                }

                @Override
                public boolean hasPrevious() {
                    return current > i;
                }

                @Override
                public Integer previous() {
                    return --current;
                }

                @Override
                public int nextIndex() {
                    return this.current + 1;
                }

                @Override
                public int previousIndex() {
                    return this.current - 1;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("Cant change view");
                }

                @Override
                public void set(Integer integer) {
                    throw new UnsupportedOperationException("Cant change view");
                }

                @Override
                public void add(Integer integer) {
                    throw new UnsupportedOperationException("Cant change view");
                }
            };
        }

        @Override
        public List<Integer> subList(int from, int to) {
            if (from >to
                    || to > size
                    || from < lowBound  ) {
                throw new IllegalArgumentException();
            }
            return new ImmutableListView(from, to);
        }
    }

    public static void main(String[] args) {
        ImmutableListView immutableListView = ImmutableListView2.getImmutableListView(10);
        immutableListView.forEach(System.out::println);
        immutableListView.subList(2,10).forEach(System.out::println);
        immutableListView.add(3);
    }

}
