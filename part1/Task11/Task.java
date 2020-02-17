package ru.mephi.java.part1.Task11;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task
{
    public  static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me a string");
        String s;
        if (in.hasNextLine()) {
            String line = in.nextLine();
            byte[] ascii = new byte[1];
            byte[] unicod = new byte[1];
            for (int i = 0; i < line.length(); i++) {
                try {
                    ascii = (line.substring(i, i + 1)).getBytes(StandardCharsets.US_ASCII);
                   // System.out.println("ascii " + ascii[0]);
                    if(ascii[0]==63) //все неопознанные в ASCII выдает кодом 63
                    {
                        int codePoint = line.codePointAt(line.offsetByCodePoints(0,i));//offsetByCodePoints возвращает char смещенный от 0 на i
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

