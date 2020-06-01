package ru.mephi.java.part4.task9;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;

public class MyToString {
    public static String myToString(Object object) throws IllegalAccessException {
        StringBuilder str = new StringBuilder();
        HashMap<Wrap, Wrap> map = new HashMap();
        if (object == null) {
            return "";
        }
        map.put(new Wrap(object), null);
        Class<?> cls = object.getClass();
        while (cls != null) {
            for (Field f : cls.getDeclaredFields()) {
                f.setAccessible(true);
                Object value = f.get(object);
                Class<?> cl = f.getType();
                if (cl.isPrimitive() || value instanceof Number || value instanceof CharSequence || "class java.lang.Boolean".equals(cl.toString())) {
                    str.append(cl.getSimpleName() + ":" + value + "  ");
                } else {
                    Wrap newParent = new Wrap(object);
                    if (isNotHere (value,  map, newParent)) {
                        map.put(new Wrap(value), newParent);
                        str.append(cl.getSimpleName() + ": {" + myToString(value, map) + "} ");
                    } else {
                        str.append(cl.getSimpleName() + "-> this;  ");
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return str.toString();
    }

    private static String myToString (Object object, HashMap<Wrap,Wrap> map) throws IllegalAccessException {
        StringBuilder str = new StringBuilder();
        if (object == null) {
            return "null";
        }
        Class<?> cls = object.getClass();
        while (cls != null) {
            for (Field f: cls.getDeclaredFields()) {
                f.setAccessible(true);
                Object value = f.get(object);
                Class<?> cl = f.getType();
                if (cl.isPrimitive() || value instanceof Number || value instanceof CharSequence || "class java.lang.Boolean".equals(cl.toString())) {
                    str.append(cl.getSimpleName() + ":" + value + "  ");
                }
                else {
                    Wrap newParent = new Wrap(object);
                    if (isNotHere (value,  map, newParent)) {
                        map.put(new Wrap(value), newParent);
                        str.append(cl.getSimpleName() + ": {" + myToString(value, map) + "} ");
                    }
                    else {
                        str.append(cl.getSimpleName() + "-> this;  ");
                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return  str.toString();
    }

    private static boolean isNotHere (Object object, HashMap<Wrap,Wrap> map, Wrap keyParent) {
        while (keyParent != null) {
            if (keyParent.equals(object)) {
                return false;
            }
            keyParent = map.get(keyParent);
        }
        return true;
    }
}
class Wrap {

    private Object obj;

    public Wrap (Object obj) {
        this.obj = obj;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Wrap) {
            Wrap w = (Wrap) o;
            return w.obj == obj;
        }
        else {
            return o == obj;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(obj);
    }

    public String toString() {
        return obj.getClass().getSimpleName() + "[" + hashCode() + "]";
    }

    public Object getObj() {
        return obj;
    }
}