package main.ru.mephi.java.part7.task9;

import java.util.HashMap;
import java.util.Map;

public class IncrementMap {
    public static void incrementContains(Map<String, Integer> map, String word) {
        if (map.containsKey(word)) {
            map.put(word, map.get(word) + 1);
        } else {
            map.put(word, 1);
        }
    }

    public static void incrementGet(Map<String, Integer> map, String word) {
        Integer count = map.get(word);
        if (count != null) {
            map.put(word, count + 1);
        } else {
            map.put(word, 1);
        }
    }

    public static void incrementGetOrDefault(Map<String, Integer> map, String word) {
        map.put(word, map.getOrDefault(word, 0) + 1);
    }

    public static void incrementPutIfAbsent(Map<String, Integer> map, String word) {
        map.put(word, map.putIfAbsent(word, 0) + 1);
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        incrementContains(map, "Aidar");
        System.out.println(map.get("Aidar"));
        incrementGet(map, "Aidar");
        System.out.println(map.get("Aidar"));
        incrementGetOrDefault(map, "Aidar");
        System.out.println(map.get("Aidar"));
        incrementPutIfAbsent(map, "Aidar");
        System.out.println(map.get("Aidar"));
    }
}


