package ru.mephi.java.everything.crypto;

import java.util.Scanner;

// простоейшее аффинное преобразование
public class AffinCrypto {
    public static void main(String[] args) {
        String table = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string: ");
        String str1 = in.nextLine();
        String str2 = "";
        System.out.println("Input A");
        int a = in.nextInt();
        System.out.println("Input B");
        int b = in.nextInt();

        for (int i = 0; i < str1.length(); i++) {
            int M;
            M = table.indexOf(str1.charAt(i));
            int C;
            C = (a * M + b) % 26;
            str2 += table.charAt(C);
            System.out.println(str1.charAt(i) + " " + M + " " + C);

        }
        System.out.println(str2);
        // for(int i=0;i<str1.length();i++)
        //  System.out.print(str1.charAt(i) + );
    }
}
