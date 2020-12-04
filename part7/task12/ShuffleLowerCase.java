package main.ru.mephi.java.part7.task12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ShuffleLowerCase {
    public static ArrayList<String> shuffle(String sentence){
        ArrayList<String> words = new ArrayList<>(Arrays.asList(sentence.split("\\s+")));
        words.set(0,unCapitalize(words.get(0)));
        removeWhiteSpace(words);
        String s;
        Collections.shuffle(words);
        words.set(0,unCapitalize(words.get(0)));
        removeWhiteSpace(words);
        return words;
    }

    private static void removeWhiteSpace(ArrayList<String> words) {
        String s=removePoint(words.get(words.size()-1));
        if(s.trim().length()!=0){
            words.set(words.size()-1,s);
        }
        else {
            words.remove(words.size()-1);
        }
    }

    private static String unCapitalize(final String line) {
        return Character.toLowerCase(line.charAt(0)) + line.substring(1);
    }

    private static String removePoint(final String line) {
        if(line.substring(line.length()-1).equals(".")){
            return line.substring(0,line.length()-1);
        }
        return line;
    }

    public static void main(String[] args) {
        shuffle("Hello I am Aidar . It is the long sentence . Let's go .").forEach(System.out::println);
    }
}
