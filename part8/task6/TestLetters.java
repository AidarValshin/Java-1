package main.ru.mephi.java.part8.task6;

import java.util.OptionalInt;

import static javax.lang.model.SourceVersion.isIdentifier;

public class TestLetters {

    public static boolean testLetters(String s){
        OptionalInt optionalInt = s.codePoints().filter(Character::isAlphabetic).findAny();
        return optionalInt.isPresent();
    }
    public static boolean testIdentifier(String s){
        return isIdentifier(s);
    }

    public static void main(String[] args) {
        System.out.println(testLetters("112"));
        System.out.println(testLetters("sdfsf"));
        System.out.println(testIdentifier("1LK"));
        System.out.println(testIdentifier("main"));
    }
}
