package main.ru.mephi.java.part8.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class VerifyFilter {

    public static void main(String[] args) throws IOException {
        String contents = Files.readString(
                Paths.get("src/resources/words.txt")); // Read file into string
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        Object[] array = words.stream().peek(e -> System.out.println("Fetching " + e))
                .filter(p -> p.length() > 2).limit(5).toArray();

        System.out.println(Arrays.toString(array));
    }
}
