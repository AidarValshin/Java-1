package main.ru.mephi.java.part7.task14;

import java.lang.reflect.Array;
import java.util.*;


public class ImmutableListView2 {
    public static ImmutableListView getImmutableListView(int i) {
        return new ImmutableListView(i);
    }

    private static class ImmutableListView implements List<Integer> {
        private final int upperBound;
        private final int shift;

        public ImmutableListView(int upperBound) {
            if (upperBound < 0) {
                throw new IllegalArgumentException(upperBound + "<0");
            }
            this.upperBound = upperBound;
            this.shift = 0;
        }

        public ImmutableListView(int shift, int upperBound) {
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
            return size() == 0;
        }

        @Override
        public boolean contains(Object o) {
            if (o instanceof Integer) {
                return (int) o <= upperBound && (int) o >= shift;
            }
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return listIterator();
        }

        @Override
        public Object[] toArray() {
            Integer[] array = new Integer[size()];
            int j = 0;
            for (int i = shift; i <= upperBound; i++) {
                array[j++] = i;
            }
            return array;
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            Object[] array;
            int j = 0;
            if (ts.length < size()) {
                array = (Object[]) Array.newInstance(ts.getClass().getComponentType(),
                        size());
            } else {
                array = (Object[]) Array.newInstance(ts.getClass().getComponentType(),
                        ts.length);
            }
            for (int i = shift; i <= upperBound; i++) {
                array[j++] = i;
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
            return true;
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
            if (i + shift <= upperBound && i >= 0) {
                return i + shift;
            }
            throw new IndexOutOfBoundsException(" your index is: " + i + ", bound is: " + (upperBound - shift));
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
                if (oo <= upperBound && oo >= shift) {
                    return oo - shift;
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
            return listIterator(0);
        }

        @Override
        public ListIterator<Integer> listIterator(int i) {
            if (i < 0 || i > size()) {
                throw new IndexOutOfBoundsException("index = " + i);
            }
            return new ListIterator<>() {
                private int current = shift - 1 + i;

                @Override
                public boolean hasNext() {
                    return current < upperBound;
                }

                @Override
                public Integer next() {
                    if (hasNext()) {
                        return ++current;
                    }
                    throw new IndexOutOfBoundsException("out of bound");
                }

                @Override
                public boolean hasPrevious() {
                    return current > shift - 1;
                }

                @Override
                public Integer previous() {
                    if (hasPrevious()) {
                        return current--;
                    }
                    throw new IndexOutOfBoundsException("out of bound");
                }

                @Override
                public int nextIndex() {
                    return current + 1 - shift;
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
            if (from > to
                    || to > size()
                    || from < 0) {
                throw new IllegalArgumentException("wrong bounds from: " + from + " to: " + to);
            }
            return new ImmutableListView(shift + from, to + shift - 1);
        }
    }

    public static void main(String[] args) {
        ImmutableListView immutableListView = ImmutableListView2.getImmutableListView(10);
        immutableListView.forEach(System.out::println);
        System.out.println();
        immutableListView.subList(2, 11).forEach(System.out::println);
        System.out.println();
        System.out.println(immutableListView.subList(5, 11).get(5));
        System.out.println();
        System.out.println(immutableListView.subList(5, 11).subList(2, 6).get(3));
        System.out.println(Arrays.toString(immutableListView.subList(5, 11).toArray()));
        System.out.println();
        ListIterator<Integer> listIterator = immutableListView.subList(5, 7).listIterator(1);
        System.out.println(Arrays.toString(immutableListView.subList(5, 7).toArray()));
        System.out.println("next index " + listIterator.nextIndex());
        System.out.println("previous index " + listIterator.previousIndex());
        System.out.println(listIterator.next());
      /*  System.out.println("next index " + listIterator.nextIndex());
        System.out.println("previous index " + listIterator.previousIndex());
        System.out.println(listIterator.next());
               */
        System.out.println("next index " + listIterator.nextIndex());
        System.out.println("previous index " + listIterator.previousIndex());
        System.out.println(listIterator.previous());
        System.out.println("next index " + listIterator.nextIndex());
        System.out.println("previous index " + listIterator.previousIndex());
        System.out.println(listIterator.previous());
        System.out.println("next index " + listIterator.nextIndex());
        System.out.println("previous index " + listIterator.previousIndex());
        //System.out.println(listIterator.previous());
        System.out.println(listIterator.next());
        System.out.println();
        System.out.println(immutableListView.subList(5, 11).get(11));
        immutableListView.add(3);
    }

}
