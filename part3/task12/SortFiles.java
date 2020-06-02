package ru.mephi.java.part3.task12;

//Given an array of File objects, sort it so that directories come before files, and
//within each group, elements are sorted by path name. Use a lambda expression to
//specify the Comparator.

import java.io.File;
import java.util.Arrays;

public class SortFiles {
    static void sortFirstDirectoryByName(File[] files) {
        Arrays.sort(files, (o1, o2) -> {
            if (o1.isDirectory() && !o2.isDirectory()) {
                return -1;
            } else if (!o1.isDirectory() && o2.isDirectory()) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        });
    }
}
