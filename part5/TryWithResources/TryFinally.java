package main.ru.mephi.java.part5.TryWithResources;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TryFinally {
    public static ArrayList<Double> readValues(String inFile, String outFile) {
        if (inFile == null || inFile.isEmpty()) {
            throw new IllegalArgumentException("invalid inFile:" + inFile);
        }
        File file = new File(inFile);
        ArrayList<Double> arrayList = new ArrayList<>();
        FileReader reader = null;
        FileWriter fout = null;
        Scanner scan = null;
        try {
            reader = new FileReader(file);
            fout = new FileWriter(outFile);
            scan = new Scanner(reader);
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
                        System.out.println("it is not   floating-point number " + e.getMessage());
                        // e.printStackTrace();
                    }
                }
                fout.write(String.valueOf(sum));
                fout.write(" \n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("it is not   floating-point number " + e.getMessage());
        } finally {
            if (scan != null) {
                scan.close();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    } //57

    public static void main(String[] args) {
        readValues("src/main/ru/mephi/resources/part5.ex6_1",
                "src/main/ru/mephi/resources/part5.TryWithResources");

        readValues("/main/ru/mephi/resources/part5.ex6_1",
                "src/main/ru/mephi/resources/part5.TryWithResources");
    }
}
