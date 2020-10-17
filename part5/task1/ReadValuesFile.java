package main.ru.mephi.java.part5.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadValuesFile {
    public static void main(String[] args) throws FileNotFoundException {
        ReadValuesFile readValuesFile = new ReadValuesFile();
        ArrayList<Double> arrayList = readValuesFile.readValues("src/main/ru/mephi/resources/part5.ex1_1");
        System.out.println(arrayList);
        System.out.println("second");
        ArrayList<Double> arrayList1 = readValuesFile.readValues("c/main/ru/mephi/resources/part5.ex1_1");


      /*  FileWriter fout = new FileWriter("src/main.mephi.ru/mephi/resources/part5.ex1_1");
        fout.write("1.01 -34.934  45.23");
        fout.close();

       */
    }

    /**
     * @param filename
     * @throws FileNotFoundException    if there is no file with name filename
     * @throws IllegalArgumentException illegal name of file.
     */

    public ArrayList<Double> readValues(String filename) throws FileNotFoundException, IllegalArgumentException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("invalid filename:" + filename);
        }
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException(" this file: " + filename + " not found");
        }
        ArrayList<Double> arrayList = new ArrayList<>();
        Scanner scan = new Scanner(new FileReader(file));
        while (scan.hasNextLine()) {
            String[] in = scan.nextLine().split("\\s+");
            for (String res : in) {
                try {
                    arrayList.add(Double.parseDouble(res));
                } catch (NumberFormatException e) {
                    System.out.println("it is not   floating-point number " + e.getMessage());
                    // e.printStackTrace();
                }
            }
        }
        scan.close();
        return arrayList;
    }
}
