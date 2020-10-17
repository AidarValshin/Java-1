package main.ru.mephi.java.part5.task2;

import main.ru.mephi.java.part5.task1.ReadValuesFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SumValues {
    public static void main(String[] args) throws FileNotFoundException {
        SumValues sumValues = new SumValues();
        System.out.println(sumValues.sumOfValues("src/main/ru/mephi/resources/part5.ex1_1"));
        System.out.println("second");
        System.out.println(sumValues.sumOfValues(""));
    }

    /**
     * @param filename
     * @throws FileNotFoundException    if there is no file with name filename
     * @throws IllegalArgumentException if there is null or empty filename .
     */
    public double sumOfValues(String filename) throws FileNotFoundException, IllegalArgumentException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("invalid filename:" + filename);
        }
        double res = 0;
        ReadValuesFile readValuesFile = new ReadValuesFile();
        ArrayList<Double> arrayList = readValuesFile.readValues(filename);
        for (double d : arrayList) {
            res += d;
        }
        return res;
    }
}
