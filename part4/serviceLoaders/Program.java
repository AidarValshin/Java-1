package ru.mephi.java.part4.serviceLoaders;

import ru.mephi.java.part4.serviceLoaders.NumericBase.NumericBase;

import java.util.ServiceLoader;

public class Program {
    private static ServiceLoader<NumericBase> numericBasesLoader =
            ServiceLoader.load(NumericBase.class);

    static NumericBase getConverter(int base) {
        for (NumericBase converter : numericBasesLoader)
            if (converter.getBase() == base)
                return converter;
        return null;
    }

    public static void main(String[] args) {
        int bases[] = {2, 8, 16};
        for (int i : bases) {
            NumericBase converter = getConverter(i);
            int res = converter.encrypt(18);
            System.out.println(res);
            System.out.println(converter.decrypt(res));
        }
    }
}
