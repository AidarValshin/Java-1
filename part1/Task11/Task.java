package ru.mephi.java.part1.task11;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//Write a program that reads a line of text and prints all characters that are not ASCII,
//together with their Unicode values.
public class Task {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me a string");
        if (in.hasNextLine()) {
            String line = in.nextLine();
            byte[] ascii;
            for (int i = 0; i < line.length(); i++) {
                try {
                    ascii = (line.substring(i, i + 1)).getBytes(StandardCharsets.US_ASCII);
                    if (ascii[0] == 63) //все неопознанные в ASCII выдает кодом 63
                    {
                        int codePoint = line.codePointAt(line.offsetByCodePoints(0, i));//offsetByCodePoints возвращает char смещенный от 0 на i
                        System.out.println(codePoint);
                    }
                } catch (Exception e) {
                    int codePoint = line.codePointAt(line.offsetByCodePoints(0, i));
                    System.out.println(codePoint);
                }
            }
        }
    }
}

