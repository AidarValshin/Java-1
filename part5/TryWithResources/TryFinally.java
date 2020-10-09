package main.ru.mephi.java.part5.TryWithResources;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TryFinally {
    public static ArrayList<Double> readValues(String inFile, String outFile) throws Exception {
        Exception mainEx = null;
        if (inFile == null || inFile.isEmpty()) {
            throw new IllegalArgumentException("invalid inFile:" + inFile);
        }
        File file = new File(inFile);
        ArrayList<Double> arrayList = new ArrayList<>();
        FileWriter fout = null;
        Scanner scan = null;
        try {
            fout = new FileWriter(outFile);
            scan = new Scanner(new FileReader(file));
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
        } catch (IOException e) {
            mainEx = e;
        } finally {
            if (scan != null) {
                scan.close();
            }
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    if (mainEx != null) {
                        mainEx.addSuppressed(e);
                    } else {
                        mainEx = e;
                    }
                }
            }
        }
        if (mainEx != null) {
            throw mainEx;
        }
        return arrayList;
    } //57

    public static void main(String[] args) throws Exception {
        readValues("src/main/ru/mephi/resources/part5.ex6_1",
                "src/main/ru/mephi/resources/part5.TryWithResources");

        readValues("/main/ru/mephi/resources/part5.ex6_1",
                "src/main/ru/mephi/resources/part5.TryWithResources");
    }
}
