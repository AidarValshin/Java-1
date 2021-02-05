package main.ru.mephi.java.part8.task5;

import java.util.stream.Stream;

public class Letters {
    public static Stream<String> letters(String s) {
      return   Stream.of(s.split(""));
    }

    public static void main(String[] args) {
        letters("sdfgsdfsdgsgsdg").forEach(System.out::println);
    }
}
