package ru.mephi.java.part3.task11;

//Using the list(FilenameFilter) method of the java.io.File class,
//write a method that returns all files in a given directory with a given extension. Use
//a lambda expression, not a FilenameFilter. Which variable from the enclosing
//scope does it capture?

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FilesInDirectory {
    public static List<String> getFiles(String pathname, String extention) {
        File path = new File(pathname);
        String[] res = path.list((extention1, name) -> name.toLowerCase().endsWith(extention));
        List<String> result = Arrays.asList(res);
        return result;
    }
}
