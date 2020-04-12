package ru.mephi.java.part1.task14;

import java.util.ArrayList;
import java.util.Scanner;

public class Magic_Square {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Give me lines");
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
       // int i = 0;
        String line =null;
        while (!(line =in.nextLine()).isEmpty()) {
            String[] result = line.split("\\s+");
            //int j =0;
            ArrayList<Integer> arrI = new ArrayList<Integer>();
            for(String s : result)
            {
                arrI.add(Integer.parseInt(s));
            }
            arr.add(arrI);
        }
       // System.out.println(arr.size());
        boolean b = true;
        int length = arr.size();
        int [] col=new int [length];
        int diag1=0;
        int lin=0;
        int diag2=0;
        int lin1=0;
        for(int i=0;i<length;i++) //перебор строк
             {
             ArrayList<Integer> arrI =arr.get(i);
             lin1=0;
             for(int j=0;j<length;j++ ) //перебор значений в строке
                  {
                      if(i==0)
                    {
                        lin+=arrI.get(j); //строки
                    }
                    else
                    {
                        lin1+=arrI.get(j); //строки
                    }
                    col[j]+=arrI.get(j); // cтолбцы
                    if(i==j)
                    {
                        diag1+=arrI.get(j);
                    }
                    if(i==(length-1-j))
                    {
                        diag2+=arrI.get(j);
                    }
                }
                // далее проверки
                if(lin!=lin1 && i!=0) //строки
                {
                    b = false;
                    break;
                }
            }
            int col0=col[0];
            for(int k=1;k<length;k++) // cтолбцы
                if(col0!=col[k])
                {
                    b=false;
                    break;
                }
        if(diag1!=diag2)
        {
            b=false;
        }
        if(diag1!=col0 || col0!=lin)
        {
            b=false;
        }
        System.out.println(b);
    }
}
