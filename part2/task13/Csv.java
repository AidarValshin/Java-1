package ru.mephi.java.part2.task13;
import com.opencsv.CSVWriter;

import java.io.FileWriter;


public class Csv {
    public static void main(String[] args) throws Exception {
        //CSVReader reader = new CSVReader(new FileReader("C:\\Users\\ВАР\\IdeaProjects\\Lec1a\\src\\main\\java\\ru\\mephi\\java\\part2\\Task13\\TemplateImportOU.csv"));
       // Map<String, String> values = new CSVReaderHeaderAware(new FileReader("yourfile.csv")).readMap();


                String csv = "data.csv";
                CSVWriter writer = new CSVWriter(new FileWriter(csv));
                //Create record
                String [] record = "4,David,Miller,Australia,30".split(",");
                //Write the record to file
                writer.writeNext(record);
                //close the writer
                writer.close();
            }

    }

