package main.ru.mephi.java.part6.task3;

import java.util.ArrayList;

public class Table<K, V> {
    private ArrayList<Entry<K, V>> arrayList = new ArrayList<>();

    public void put(K key, V value) {
        Entry<K, V> entry = null;
        for (int i = 0; i < arrayList.size(); i++) {
            entry = arrayList.get(i);
            if (entry.getKey() == key) {
                arrayList.set(i, new Entry<>(key, value));
                return;
            }
        }
        arrayList.add(new Entry<>(key, value));
    }

    public Entry<K, V> get(K key) {
        Entry<K, V> entry = null;
        for (int i = 0; i < arrayList.size(); i++) {
            entry = arrayList.get(i);
            if (entry.getKey() == key) {
                return entry;
            }
        }
        return null;
    }

    public Entry<K, V> remove(K key) {
        Entry<K, V> entry = null;
        for (int i = 0; i < arrayList.size(); i++) {
            entry = arrayList.get(i);
            if (entry.getKey() == key) {
                return arrayList.remove(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Table<Integer,Integer> table = new Table<>();
        table.put(1,2);
        table.put(2,3);
        System.out.println(table.get(1).getValue());
        System.out.println(table.get(2).getValue());
        table.put(1,10);
        System.out.println(table.get(1).getValue());
        table.remove(1);
        System.out.println(table.get(1));
    }

}
