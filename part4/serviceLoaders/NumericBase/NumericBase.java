package ru.mephi.java.part4.serviceLoaders.NumericBase;

public interface NumericBase {
    //from 10 base to this base
    int encrypt(int source);
    //from this base to 10 base
    int decrypt(int source);
    int getBase();
}
