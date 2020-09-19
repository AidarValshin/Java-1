package main.ru.mephi.java.part5.ExceptinsVsErrorCodes;

import main.ru.mephi.java.part5.task1.ReadValuesFile;
import main.ru.mephi.java.part5.task4.IntWrapper;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Program {

    public static void exceptions(String inFile1, String inFile2, String inFile3, String outFile) {
        ReadValuesFile readValuesFile = new ReadValuesFile();
        try {
            ArrayList<Double> arrayList1 = readValuesFile.readValues(inFile1);
            ArrayList<Double> arrayList2;
            ArrayList<Double> arrayList3;
            arrayList2 = readValuesFile.readValues(inFile2);
            arrayList3 = readValuesFile.readValues(inFile3);
            write(outFile, arrayList1, arrayList2, arrayList3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace(System.out);
        }
    } //14

    public static void codes(String inFile1, String inFile2, String inFile3, String outFile) {
        main.ru.mephi.java.part5.task4.ReadValuesFile readValuesFile = new main.ru.mephi.java.part5.task4.ReadValuesFile();
        IntWrapper error = new IntWrapper(0);
        try {
            ArrayList<Double> arrayList1 = readValuesFile.readValues(inFile1, error);
            ArrayList<Double> arrayList2;
            ArrayList<Double> arrayList3;
            if (error.i == 0) {
                arrayList2 = readValuesFile.readValues(inFile2, error);
            } else {
                if (error.i == 2) {
                    System.out.println("it is invalid  inFile1");
                } else if (error.i == 1) {
                    System.out.println(inFile1 + "   doesn exist");
                }
                return;
            }
            if (error.i == 0) {
                arrayList3 = readValuesFile.readValues(inFile3, error);
            } else {
                if (error.i == 2) {
                    System.out.println("it is invalid  inFile2");
                } else if (error.i == 1) {
                    System.out.println(inFile2 + "   doesn exist");
                }
                return;
            }
            if (error.i == 0) {
                write(outFile, arrayList1, arrayList2, arrayList3);
            } else {
                if (error.i == 2) {
                    System.out.println("it is invalid  inFile3");
                } else if (error.i == 1) {
                    System.out.println(inFile3 + "   doesn exist");
                }
                return;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } //45


    public static void write(String outFile, ArrayList<Double>... arrays) {
        double sum;
        try (FileWriter fout = new FileWriter(outFile)) {
            for (ArrayList<Double> array : arrays) {
                sum = 0;
                for (double d : array) {
                    sum += d;
                }
                fout.write(String.valueOf(sum));
                fout.write(" \n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        exceptions("src/main/ru/mephi/resources/part5.ex1_1"
                , ""
                , "src/main/ru/mephi/resources/part5.ex6_1", "src/main/ru/mephi/resources/part5.exceptions");
        System.out.println("part2");
        exceptions("src/main/ru/mephi/resources/part5.ex1_1"
                , "/main/ru/mephi/resources/part5.ex1_1"
                , "src/main/ru/mephi/resources/part5.ex6_1", "src/main/ru/mephi/resources/part5.exceptions");
        System.out.println("codes");

        codes("src/main/ru/mephi/resources/part5.ex1_1"
                , ""
                , "src/main/ru/mephi/resources/part5.ex6_1", "src/main/ru/mephi/resources/part5.exceptions");
        System.out.println("part2");
        codes("src/main/ru/mephi/resources/part5.ex1_1"
                , "main/ru/mephi/resources/part5.ex1_1"
                , "src/main/ru/mephi/resources/part5.ex6_1", "src/main/ru/mephi/resources/part5.exceptions");
    }
}
