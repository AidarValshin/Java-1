package main.ru.mephi.java.part6.Additionally;

import main.ru.mephi.java.Employee.Employee;
import main.ru.mephi.java.Employee.Manager;

import java.util.HashMap;
import java.util.Map;

public class PECS {
    public <K, V> V producerConsumer(Map<K, V> map, K key, V value) {
        map.put(key, value);
        return getHelper(map,key);
    }

    private <K, V> void addHelper(Map<K, ? super V> map, K key, V value) {
        map.put(key, value);
    }

    private <K, V> V getHelper(Map<K, ? extends V> map, K key) {
        return map.get(key);
    }

    public static void main(String[] args) {
        Map<Integer, Employee> mapEmpl = new HashMap<>();
        PECS pecs = new PECS();
        pecs.producerConsumer(mapEmpl, 0, new Manager("b", 200, 100));
    }
}
