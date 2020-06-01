package ru.mephi.java.part4.proxys;

import ru.mephi.java.part4.task2.Point;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PointInvocationHandler implements InvocationHandler {
    private Point point;

    public PointInvocationHandler(Point point){
        this.point=point;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {

        System.out.println(point + "." + method.getName()+ " "+ Arrays.toString(args));
        System.out.println(" length vector "+ point.getX()+";"+point.getY()+" from 0;0 = "
                + Math.sqrt((Math.pow(point.getX(),2)+Math.pow(point.getY(),2))));

        Method m=null;
        try {
            m=point.getClass().getMethod(method.getName(),Object.class);
        } catch(NoSuchMethodException e) {
            System.out.println(e.toString());
        }
       if(m!=null){
           return m.invoke(point, args);
       }
        return method.invoke(point, args);

    }
}
