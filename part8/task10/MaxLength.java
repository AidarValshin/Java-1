package main.ru.mephi.java.part8.task10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MaxLength {
    public static List<String> getStringsByMaxLength(String path) throws IOException {
        String contents = Files.readString(
                Paths.get(path)); // Read file into string
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        Map<Integer, List<String>> collect = words.stream().collect(
                Collectors.groupingBy(String::length));
        Optional<Integer> max=collect.keySet().stream().sorted().max(Comparator.comparingInt(x->x));
        return  collect.getOrDefault(max.orElse(0),Collections.EMPTY_LIST);
    }

    public static void main(String[] args) throws IOException {
      getStringsByMaxLength( "src/resources/words.txt").forEach(System.out::println);
    }
}
