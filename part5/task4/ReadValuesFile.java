package main.ru.mephi.java.part5.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadValuesFile {
    /**
     * @param filename
     * @param error
     * @error 1    if there is no file with name filename
     * @error 2  illegal name of file.
     */

    public ArrayList<Double> readValues(String filename, IntWrapper error) throws FileNotFoundException {
        if (filename == null || filename.isEmpty()) {
           error.i=2;
           return null;
        }
        File file = new File(filename);
      if (!file.exists()) {
          error.i=1;
          return null;
      }
        ArrayList<Double> arrayList = new ArrayList<>();
        Scanner scan = new Scanner(new FileReader(file));
        while (scan.hasNextLine()) {
            String[] in = scan.nextLine().split("\\s+");
            for (String res : in) {

                    if(res.matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+"))
                    {
                        arrayList.add(Double.parseDouble(res));
                    }

                    else{
                    System.out.println("it is not   floating-point number "+res);
                 // e.printStackTrace();
                }
            }
        }
        scan.close();
        return arrayList;
    }


    public static void main(String[] args) throws FileNotFoundException {
        IntWrapper error = new IntWrapper(0);
        ReadValuesFile readValuesFile = new ReadValuesFile();
        ArrayList<Double> arrayList = readValuesFile.readValues("src/main/ru/mephi/resources/part5.ex1_1",error);
        System.out.println(arrayList);
        System.out.println(error.i);
        System.out.println("second");
        ArrayList<Double> arrayList1 = readValuesFile.readValues("s/main/ru/mephi/resources/part5.ex1_1",error);
        System.out.println(error.i);

      /*  FileWriter fout = new FileWrSystem.out.println(error.i);iter("src/main.mephi.ru/mephi/resources/part5.ex1_1");
        fout.write("1.01 -34.934  45.23");
        fout.close();

       */
    }
}
