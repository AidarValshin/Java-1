package ru.mephi.java.part1.task16;

import java.util.Scanner;

//Improve the average method so that it is called with at least one parameter
public class NewAverage {
    public static void main(String[] args) {
        System.out.println(average());
    }

    public static double average() {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me numbers ");
        int count = 0;
        double sum = 0;
        String line;
        while (!(line = in.nextLine()).isEmpty()) {
            String[] result = line.split("\\s+");
            for (String s : result) {
                sum += (Double.parseDouble(s));
                count++;
            }
        }
        if (count > 0) {
            double average = sum / count;
            return average;
        } else if (count == 0) {
            return 0;
        }
        return -1;
    }
}

