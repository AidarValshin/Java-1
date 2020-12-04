package main.ru.mephi.java.part7.task11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class readSentenceShuffle {
    public static ArrayList<String> shuffle(String sentence){
        ArrayList<String> words = new ArrayList<>(Arrays.asList(sentence.split("\\s+")));
        Collections.shuffle(words.subList(1, words.size()-1));
        return words;
    }

    public static void main(String[] args) {
        shuffle("Hello I am Aidar . It is the long sentence . Let's go !").forEach(System.out::println);
    }
}
