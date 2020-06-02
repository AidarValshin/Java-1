package ru.mephi.java.part4.loadingResources;
//simple example of loading resourses

import java.io.InputStream;
import java.util.Scanner;

public class LoadingResources {
    public static void main(String[] args) {
        InputStream is = LoadingResources
                .class.getResourceAsStream("/my.txt");
        Scanner sc = new Scanner(is);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        sc.close();

    }

}
