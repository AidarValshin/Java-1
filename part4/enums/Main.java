package ru.mephi.java.part4.enums;


public class Main {
    public static void main(String[] args) {
        //норм работа
        printConst("XL");
        printEnum(Size1.valueOf("EXTRA_LARGE"));
        //ошибки
        printConst("XXXX"); //здесь сами ловим исключение+
        printEnum(Size1.valueOf("XXXX")); // здесь в рантайме перечисление ловит исключение
      // printEnum(Size1.EXTRA_LARGE_LARGE); //компилятор сразу указывает на ошибку
    }


    public static void printConst(String s){
        if(s.equals(Size2.SMALL)){
            System.out.println("SMALL");
        }
        else if (s.equals(Size2.MEDIUM)){
            System.out.println("MEDIUM)");
        }
        else if(s.equals(Size2.LARGE)){
            System.out.println("LARGE");
        }
        else if(s.equals(Size2.EXTRA_LARGE)){
            System.out.println("EXTRA_LARGE");
        }
        else{
            System.out.println("wrong opperand");
        }
    }

    public static void printEnum(Size1 s){
        System.out.println(s.name());
    }
}

