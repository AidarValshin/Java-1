package ru.mephi.java.part3.task10;
import java.io.File;
import static ru.mephi.java.part3.task10.Subdirectories.*;

public class Main
{
    public static void main(String args[])
    {
        // Определение директории
        File dir = new File(".");
        // Чтение полного списка файлов каталога
        File[] lst1 = dir.listFiles();
        // Чтение списка файлов каталога

        System.out.println ("lst1.length = " + lst1.length);

        System.out.println ("lst2.length = " + getSubdirectories(".").size());
    }
}
