package ru.mephi.java.part3.task12;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        final String pathName = "C:\\Users\\user\\Desktop";
        File dir = new File(pathName);
        List<String> result = Arrays.asList(dir.list());
        System.out.println(result);
        File[] lst = dir.listFiles();
        SortFiles.sortFirstDirectoryByName(lst);
        for (File f : lst) {
            System.out.println(f.getName());
        }
    }
}
