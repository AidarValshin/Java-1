package main.ru.mephi.java.part5.CatchSomeExceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            throw new FileNotFoundException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
