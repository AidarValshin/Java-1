package ru.mephi.java.part2.task13;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class Read {
    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader("data.csv"));
    }
}
