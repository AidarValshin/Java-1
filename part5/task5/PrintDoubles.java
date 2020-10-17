package main.ru.mephi.java.part5.task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintDoubles {
    public static void printIntegersFromFile(File source, File output) {
        PrintWriter out = null;
        Scanner in = null;
        if (!source.exists()) {
            System.err.printf("Source file : %s  could not be found ", source);
            return;
        }
        if (source == null || output == null) {
            System.err.printf("Wrong source: %s and output : %s files", source, output);
            return;
        }
        try {
            in = new Scanner(source);
            out = new PrintWriter(output);
            while (in.hasNextLine()) {
                String[] line = in.nextLine().split("\\s+");
                for (String res : line) {
                    try {
                        out.print(Double.parseDouble(res));
                        out.print("  ");
                    } catch (NumberFormatException e) {
                        System.out.println("it is not   floating-point number " + e.getMessage());
                        // e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.printf("File: %s coul not be found", e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Exception is: " + e);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void main(String[] args) {
        PrintDoubles.printIntegersFromFile(new File("src/main/ru/mephi/resources/part5.ex1_1")
                , new File("src/main/ru/mephi/resources/part5.ex5"));
        PrintDoubles.printIntegersFromFile(new File(" ")
                , new File("src/main/ru/mephi/resources/part5.ex5"));
    }
}

