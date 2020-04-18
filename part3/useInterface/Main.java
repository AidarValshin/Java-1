package ru.mephi.java.part3.useInterface;

public class Main {
    public interface MyInt {
        int met(int a);
    }

    public static void main(String[] args) {
       MyInt i=(a)->a+1;
        i.met(3);
    }
}
