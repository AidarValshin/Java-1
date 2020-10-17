package main.ru.mephi.java.part5.TryWithResources;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programm {
    public static ArrayList<Double> readValues(String inFile, String outFile) throws IOException {
        if (inFile == null || inFile.isEmpty()) {
            throw new IllegalArgumentException("invalid inFile:" + inFile);
        }
        File file = new File(inFile);
        ArrayList<Double> arrayList = new ArrayList<>();
        try (FileWriter fout = new FileWriter(outFile);
             Scanner scan = new Scanner(new FileReader(file))) {
            double d;
            double sum;
            while (scan.hasNextLine()) {
                String[] in = scan.nextLine().split("\\s+");
                sum = 0;
                for (String res : in) {
                    try {
                        d = Double.parseDouble(res);
                        arrayList.add(d);
                        sum += d;
                    } catch (NumberFormatException e) {
                        System.out.println("it is not   floating-point number ");
                        e.printStackTrace(System.out);
                        // e.printStackTrace();
                    }
                }
                fout.write(String.valueOf(sum));
                fout.write(" \n");
            }
        }
        return arrayList;
    } //29

    public static void main(String[] args) throws IOException {
        readValues("src/main/ru/mephi/resources/part5.ex6_1",
                "src/main/ru/mephi/resources/part5.TryWithResources");

        readValues("/main/ru/mephi/resources/part5.ex6_1",
                "src/main/ru/mephi/resources/part5.TryWithResources");
    }

}
