package main.ru.mephi.java.part5.task4;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SumValues {
    public static void main(String[] args) throws FileNotFoundException {
        SumValues sumValues = new SumValues();
        IntWrapper error = new IntWrapper(0);
        System.out.println(sumValues.sumOfValues("src/main/ru/mephi/resources/part5.ex1_1", error));
        System.out.println(error.i);
        System.out.println("second");
        System.out.println(sumValues.sumOfValues("", error));
        System.out.println(error.i);
    }

    /**
     * @param filename
     * @param error
     * @error 1    if there is no file with name filename
     * @error 2  illegal name of file.
     */
    public double sumOfValues(String filename, IntWrapper error) throws FileNotFoundException {
        if (filename == null || filename.isEmpty()) {
            error.i = 2;
            return 0;
        }
        double res = 0;
        ReadValuesFile readValuesFile = new ReadValuesFile();
        ArrayList<Double> arrayList = readValuesFile.readValues(filename, error);
        for (double d : arrayList) {
            res += d;
        }
        return res;
    }
}
