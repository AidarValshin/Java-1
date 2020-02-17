package ru.mephi.java.part1.Task3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class FindMax
{
    public  static void main(String[] args)
    {
        work(input());
    }

    public static ArrayList<Integer> input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Give me  numbers");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        String line =null;
        while (!(line =in.nextLine()).isEmpty()) {
            String[] result = line.split("\\s+");
            for(String s : result)
            {
                arr.add(Integer.parseInt(s));
            }
        }
        return arr;
    }

    public static void work( ArrayList<Integer> arr) {
        int a1= Integer.MIN_VALUE;
        int a2= Integer.MIN_VALUE;
        int b;
        for (int i=0;i<arr.size();i++)
        {
            b=arr.get(i);
            if (a1<b)
            {
                a1=b;
            }
        }
        a2=Collections.max (arr);
        System.out.println("max integer 1 = " +a1);
        System.out.println("max integer 2 = " +a2);
    }
    }

