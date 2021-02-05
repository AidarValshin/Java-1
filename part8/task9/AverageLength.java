package main.ru.mephi.java.part8.task9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AverageLength {
    public static double average(String path) throws IOException {
        String contents = Files.readString(
                Paths.get(path)); // Read file into string
        List<String> words = Arrays.asList(contents.split("\\PL+"));
return words.stream().collect(Collectors.summarizingInt(String::length)).getAverage();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(average( "src/resources/words.txt"));
    }

}
