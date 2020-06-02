package ru.mephi.java.part4.serviceLoaders.Implementaitions;

import ru.mephi.java.part4.serviceLoaders.NumericBase.NumericBase;

public class To16Base implements NumericBase {
    @Override
    public int encrypt(int source) {
        return Integer.parseInt(Integer.toString(source, 16));
    }

    @Override
    public int decrypt(int source) {
        return Integer.parseInt(Integer.toString(source, 10), 16);
    }

    @Override
    public int getBase() {
        return 16;
    }
}
