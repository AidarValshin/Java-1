package main.ru.mephi.java.part6.Additionally;


import main.ru.mephi.java.Employee.Employee;
import main.ru.mephi.java.part6.task7.Pair;

import java.util.ArrayList;

public class BreakGeneric {
    public static void main(String[] args) {
    //a
        ArrayList<Integer> arrayList= new ArrayList<>();
        Pair<String> stringPair= new Pair(new Employee("A",100)
                        ,new Employee("A",100));
        System.out.println(stringPair);//нет ошибок
       Object obj = stringPair.get1();
        System.out.println(obj.toString());
        Employee empl=(Employee) obj;
        System.out.println(empl.getName());
        String str1 = stringPair.get1();//ClassCastException
/*
        Pair<String> stringPair1=
                (Pair<String>) new Pair<>(new Employee("A",100)
                        ,new Employee("A",100));
 */

        Pair<Employee> emplPair=
                new Pair(new Employee("A",100)
                        ,new Employee("A",100));
    //  Pair<String> stringPair1=(Pair<String>)emplPair;
       Pair<String> stringPair1= (Pair)emplPair;//обратна€ совместимость Pair<Object>
        stringPair1=  stringPair.getClass().cast(emplPair);
        System.out.println(stringPair1);//нет ошибок
         System.out.println(stringPair1.get1()); //ClassCastException
        Pair<?> pair=emplPair;
        Pair<String> stringPair2=(Pair<String>) pair;


    }
}
