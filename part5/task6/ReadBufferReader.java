package main.ru.mephi.java.part5.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadBufferReader {

    public static void readA(Path path) {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("Caught IOException A1: " + ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close(); // Caution—might throw an exception
                } catch (IOException e) {
                    System.out.println("Caught IOException A2: " + e.getMessage());
                }
            }
        }
    }

    public static void readB(Path path) {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String line = null;
            while (true) {
                try {
                    if (!((line = in.readLine()) != null)) break;
                } catch (IOException e) {
                    System.out.println("Caught IOException B1: " + e.getMessage());
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Caught IOException B2: " + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("Caught IOException B3: " + e.getMessage());
            }
        }
    }

    public static void readC(Path path) {

        try (BufferedReader in = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Caught IOException C: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        ReadBufferReader.readA(Paths.get("src/main/ru/mephi/resources/part5.ex1_1"));
        ReadBufferReader.readA(Paths.get("src/main/ru/mephi/resources/part5.ex6_1"));
        ReadBufferReader.readA(Paths.get(""));
        System.out.println();
        System.out.println("B");
        System.out.println();
        ReadBufferReader.readB(Paths.get("src/main/ru/mephi/resources/part5.ex1_1"));
        ReadBufferReader.readB(Paths.get("src/main/ru/mephi/resources/part5.ex6_1"));
        ReadBufferReader.readB(Paths.get(""));
        System.out.println();
        System.out.println("C");
        System.out.println();
        ReadBufferReader.readC(Paths.get("src/main/ru/mephi/resources/part5.ex1_1"));
        ReadBufferReader.readC(Paths.get("src/main/ru/mephi/resources/part5.ex6_1"));
        ReadBufferReader.readC(Paths.get(""));
    }
}
