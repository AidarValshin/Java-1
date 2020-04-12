package ru.mephi.java.part3.task11;

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
