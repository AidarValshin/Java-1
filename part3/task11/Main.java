package ru.mephi.java.part3.task11;

public class Main {
    public static void main(String args[]) {
        final String fileExtension = ".java";
        final String pathName = "C:\\Users\\ВАР\\IdeaProjects\\Lec1a\\src\\main\\java\\ru\\mephi\\java\\part3\\task11";
        System.out.println(FilesInDirectory.getFiles(pathName, fileExtension));
    }
}
