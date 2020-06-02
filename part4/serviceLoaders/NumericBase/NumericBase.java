package ru.mephi.java.part4.serviceLoaders.NumericBase;

public interface NumericBase {
    //from N base to this base
    int encrypt(int source);

    //from this base to N base
    int decrypt(int source);

    int getBase();
}
