package ru.mephi.java.part4.proxys;


import ru.mephi.java.part4.task2.Point;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Point [] p= new Point[10];
        for (int i=0;i<10; i++){
            p[i]=new Point(i,10-i);
        }
        Object [] o=new Object[10];
        for (int i=0;i<10; i++){
            o[i]=  Proxy.newProxyInstance(null,p[i].getClass().getInterfaces(),new PointInvocationHandler(p[i]));
        }
        for (int i=0;i<10; i++){
            for (int j=0;j<10; j++){
                System.out.println(o[i].equals(p[j]));
                System.out.println();
            }
        }
    }
}

