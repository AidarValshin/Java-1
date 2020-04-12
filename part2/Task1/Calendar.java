package ru.mephi.java.part2.task1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calendar {
    public static void main(String[] args) {
        System.out.println(" Sun  Mon Tue Wed Thu Fri Sat ");
        int month = 2;
        LocalDate date = LocalDate.of(2020, month, 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        if (value == 7) {
            value = 1;
        } else {
            value += 1;
        }
        for (int i = 1; i < value; i++)
            System.out.print("    ");
        while (date.getMonthValue() == month) {
            System.out.printf("%4d", date.getDayOfMonth());
            if (date.getDayOfWeek().getValue() == 6) {
                System.out.printf("\n");
            }
            date = date.plusDays(1);
        }
        System.out.println(" ");
    }
}
