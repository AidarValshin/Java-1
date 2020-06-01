package ru.mephi.java.part4.task9;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;

public class UniversalToString {
    public static String toString(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return " ";
        }
        HashMap hash = new HashMap();
        hash.put(new Wrapper(obj), null);
        return myToString(obj, hash);
    }

    private static String myToString(Object object, HashMap<Wrapper, Wrapper> hash) throws IllegalAccessException {
        StringBuilder result = new StringBuilder();
        if (object == null) {
            return " ";
        }
        Class<?> cls = object.getClass();
        while (cls != null) {
            for (Field f : cls.getDeclaredFields()) {
                f.setAccessible(true);
                Object value = f.get(object);
                Class<?> cl = f.getType();
                if (cl.isPrimitive() || value instanceof Number
                        || value instanceof Character || value instanceof CharSequence) {
                    result.append(f.getName() + ":" + value + " ");
                } else {
                    Wrapper wrapParent = new Wrapper(object);
                    Wrapper wrapValue = new Wrapper(value);
                    if (isNotCicle(hash, wrapValue, wrapParent)) {
                        hash.put(wrapValue, wrapParent);
                        result.append(cl.getSimpleName() + ": [" + myToString(value, hash) + "] ");
                    } else {
                        result.append(cl.getSimpleName() + "-> CICLE;  ");

                    }
                }
            }
            cls = cls.getSuperclass();
        }
        return result.toString();
    }


    private static boolean isNotCicle(HashMap<Wrapper, Wrapper> hash, Wrapper object, Wrapper keyParent) {
        while (keyParent != null) {
            if (keyParent.equals(object)) {
                return false;
            }
            keyParent = hash.get(keyParent);
        }
        return true;
    }
}

class Wrapper {
    Object obj;

    Wrapper(Object obj) {
        this.obj = obj;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Wrapper) {
            Wrapper w = (Wrapper) o;
            return w.obj == obj;
        } else {
            return o == obj;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(obj);
    }
}