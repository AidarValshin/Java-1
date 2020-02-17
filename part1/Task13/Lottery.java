package ru.mephi.java.part1.Task13;
import java.util.Random;
import java.util.*;

public class Lottery {
    public  static void main(String[] args)
    {
        ArrayList <Integer> arr =new ArrayList<>();
        for(int i=1;i<=49;i++)
        {
            arr.add(i);
        }
        ArrayList <Integer> a= new ArrayList<>();
        Random rnd = new Random();
        for (int j=0;j<6;j++)
        {
            a.add(arr.remove( rnd.nextInt((49-j))));
        }
        Collections.sort(a);
        System.out.println(a);
    }
}
