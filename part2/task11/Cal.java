package ru.mephi.java.part2.task11;
//Rewrite the Cal class to use static imports for the System and LocalDate
//classes.

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.lang.System.out;
import static java.time.LocalDate.of;

public class Cal {
    public static void cal(int month) {
        System.out.println(" Sun  Mon Tue Wed Thu Fri Sat ");
        LocalDate date = of(2020, month, 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();
        if (value == 7) {
            value = 1;
        } else {
            value += 1;
        }
        for (int i = 1; i < value; i++)
            out.print("    ");
        while (date.getMonthValue() == month) {
            out.printf("%4d", date.getDayOfMonth());
            if (date.getDayOfWeek().getValue() == 6) {
                out.printf("\n");
            }
            date = date.plusDays(1);
        }
        out.println(" ");
    }
}
