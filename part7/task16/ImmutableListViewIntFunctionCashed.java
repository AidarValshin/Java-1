package main.ru.mephi.java.part7.task16;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntFunction;

public class ImmutableListViewIntFunctionCashed {
    public static ImmutableListView getImmutableListView(int i, IntFunction<Integer> intFunction) {
        return new ImmutableListView(i, intFunction);
    }

    private static class ImmutableListView implements List<Integer> {
        private final int size;
        private final int lowBound;
        private final IntFunction<Integer> intFunction;
        private Map<Integer,Integer> cash=new LinkedHashMap<>();

        private int getAppliedOrSetCash(int index){
            if(cash.containsKey(index)){
                System.out.println("get");
                return cash.get(index);
            }
            else {
                int result = intFunction.apply(index);
               if(cash.size()<100){
                   cash.put(index,result);
                   System.out.println("put");
               }
               else{
                   Iterator iterator=cash.entrySet().iterator();
                   iterator.next();
                   iterator.remove();
                   cash.put(index,result);
                   System.out.println("replace");
               }
               return result;
            }
        }
        public ImmutableListView(int size, IntFunction<Integer> intFunction) {
            this.intFunction = intFunction;
            if (size < 0) {
                throw new IllegalArgumentException(size + "<0");
            }
            this.size = size;
            this.lowBound = 0;
        }

        public ImmutableListView(int lowBound, int size, IntFunction<Integer> intFunction) {
            this.intFunction = intFunction;
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
                for (int i = lowBound; i <= size; i++) {
                    if ( getAppliedOrSetCash(i) == (int) o) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<>() {
                private int current = lowBound - 1;

                @Override
                public boolean hasNext() {
                    return this.current < size;
                }

                @Override
                public Integer next() {
                    if (this.current > size) {
                        throw new IndexOutOfBoundsException("out of bound");
                    }
                    return  getAppliedOrSetCash(++this.current);
                }
            };
        }

        @Override
        public Object[] toArray() {
            Integer[] array = new Integer[size];
            for (int i = this.lowBound; i <= size; i++) {
                array[i] =  getAppliedOrSetCash(i);
            }
            return array;
        }

        @Override
        public <T> T[] toArray(T[] ts) {
            Object[] array = null;
            if (ts.length > this.size) {
                array = (Object[]) Array.newInstance(ts.getClass().getComponentType(), size);
                for (int i = this.lowBound; i <= size; i++) {
                    array[i] =  getAppliedOrSetCash(i);
                }
            } else {
                array = (Object[]) Array.newInstance(ts.getClass().getComponentType(), ts.length);
                for (int i = this.lowBound; i < ts.length; i++) {
                    array[i] =  getAppliedOrSetCash(i);
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
            return  getAppliedOrSetCash(i);
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
                for (int i = lowBound; i <= size; i++) {
                    if ( getAppliedOrSetCash(i) == oo) {
                        return i;
                    }
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            int index = -1;
            if (o instanceof Integer) {
                int oo = (int) o;
                for (int i = lowBound; i <= size; i++) {
                    if ( getAppliedOrSetCash(i) == oo) {
                        index = i;
                    }
                }
            }
            return index;
        }

        @Override
        public ListIterator<Integer> listIterator() {
            return new ListIterator<Integer>() {
                private int current = lowBound - 1;

                @Override
                public boolean hasNext() {
                    return this.current < size;
                }

                @Override
                public Integer next() {
                    if (this.current > size) {
                        throw new IndexOutOfBoundsException("out of bound");
                    }
                    return  getAppliedOrSetCash(++this.current);
                }

                @Override
                public boolean hasPrevious() {
                    return current > lowBound;
                }

                @Override
                public Integer previous() {
                    return  getAppliedOrSetCash(--current);
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
                    return  getAppliedOrSetCash(++this.current);
                }

                @Override
                public boolean hasPrevious() {
                    return current > i;
                }

                @Override
                public Integer previous() {
                    return  getAppliedOrSetCash(--current);
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
            if (from > to
                    || to > size
                    || from < lowBound) {
                throw new IllegalArgumentException();
            }
            return new ImmutableListView(from, to, intFunction);
        }
    }

    public static void main(String[] args) {
        ImmutableListViewIntFunctionCashed.ImmutableListView immutableListView
                = ImmutableListViewIntFunctionCashed.getImmutableListView(98, p -> p+2);
        immutableListView.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");
       Iterator<Integer> listIterator = immutableListView.listIterator(98);
        Iterator<Integer> iterator = immutableListView.iterator();
        for(int i=0;i<98;i++){
            System.out.println(iterator.next());
        }
        //System.out.println(immutableListView.contains(-5));
        //System.out.println(immutableListView.contains(-11));
        immutableListView.add(3);

    }
}
