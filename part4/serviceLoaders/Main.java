package ru.mephi.java.part4.serviceLoaders;

import ru.mephi.java.part4.serviceLoaders.Implementaitions.To16Base;
import ru.mephi.java.part4.serviceLoaders.Implementaitions.To2Base;
import ru.mephi.java.part4.serviceLoaders.Implementaitions.To8Base;
import ru.mephi.java.part4.serviceLoaders.NumericBase.NumericBase;

public class Main {
    public static void main(String[] args) {
        NumericBase t2 = new To2Base();
        System.out.println(t2.encrypt(18));
        System.out.println(t2.decrypt(t2.encrypt(18)));

        NumericBase t8 = new To8Base();
        System.out.println(t8.encrypt(18));
        System.out.println(t8.decrypt(t8.encrypt(18)));

        NumericBase t16 = new To16Base();
        System.out.println(t16.encrypt(18));
        System.out.println(t16.decrypt(t16.encrypt(18)));

    }
}

