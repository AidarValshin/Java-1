package ru.mephi.java.part4.enums;
// simple example why enums better than constants

public class Main {
    public static void main(String[] args) {
        //norm
        printConst("XL");
        printEnum(Size1.valueOf("EXTRA_LARGE"));
        //errors
        printConst("XXXX"); // can take every string
        printEnum(Size1.valueOf("XXXX")); // err in runtime
        // printEnum(Size1.EXTRA_LARGE_LARGE); //compile error. this element doesnt exist
    }

    public static void printConst(String s) {
        if (s.equals(Size2.SMALL)) {
            System.out.println("SMALL");
        } else if (s.equals(Size2.MEDIUM)) {
            System.out.println("MEDIUM)");
        } else if (s.equals(Size2.LARGE)) {
            System.out.println("LARGE");
        } else if (s.equals(Size2.EXTRA_LARGE)) {
            System.out.println("EXTRA_LARGE");
        } else {
            System.out.println("wrong opperand");
        }
    }

    public static void printEnum(Size1 s) {
        System.out.println(s.name());
    }
}

