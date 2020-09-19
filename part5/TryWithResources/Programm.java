package main.ru.mephi.java.part5.TryWithResources;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Programm {
    public static ArrayList<Double> readValues(String inFile,String outFile) {
        if (inFile == null || inFile.isEmpty()) {
            throw new IllegalArgumentException("invalid inFile:" + inFile);
        }
        File file = new File(inFile);
        ArrayList<Double> arrayList = new ArrayList<>();
        try (FileReader reader =new FileReader(file);
             FileWriter fout = new FileWriter(outFile);Scanner scan = new Scanner(reader)) {
            double d;
            double sum;
            while (scan.hasNextLine()) {
                String[] in = scan.nextLine().split("\\s+");
                sum=0;
                for (String res : in) {
                    try {
                        d=Double.parseDouble(res);
                        arrayList.add(d);
                        sum+=d;
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
        }
        catch (NumberFormatException e) {
            System.out.println("it is not   floating-point number "+e.getMessage());
        }
        return arrayList;
    } //35

    public static void main(String[] args) {
        readValues("src/main/ru/mephi/resources/part5.ex6_1",
                "src/main/ru/mephi/resources/part5.TryWithResources");

        readValues("/main/ru/mephi/resources/part5.ex6_1",
                "src/main/ru/mephi/resources/part5.TryWithResources");
    }

}
