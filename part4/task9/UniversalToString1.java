package ru.mephi.java.part4.task9;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;

public class UniversalToString1 {
    public static String toString(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return "";
        }
        HashMap hash = new HashMap();
        hash.put(new Wrapper(obj), null);
        return myToString(obj, hash);
    }

    public static String myToString(Object obj, HashMap h) throws IllegalAccessException {
        StringBuilder result = new StringBuilder();
        if (obj == null) {
            return " ";
        }
        Class<?> cl = obj.getClass();
        while (cl != null) {
            for (Field f : cl.getDeclaredFields()) {
                f.setAccessible(true);
                Object value = f.get(obj);
                Class<?> clValue = f.getType();
                if (clValue.isPrimitive() || value instanceof Number
                        || value instanceof Character || value instanceof CharSequence) {
                    result.append(f.getName() + ":" + value + " ");
                } else {
                    Wrapper val = new Wrapper(obj);
                    Wrapper key = new Wrapper(value);
                    if (!isCicle(h, val, key)) {
                        result.append(cl.getSimpleName() + ":{ " + myToString(value, h) + " }");
                        h.put(key, val);//обертка

                    } else  {
                        result.append("CICLE");
                        return result.toString();
                    }
                }
                    /*
                    if (h.containsKey(key)) {
                        if (!isCicle(h, val, key)) {
                            result.append(cl.getSimpleName() + ":{ " + myToString(value, h) + " }");
                            return result.toString();
                        } else if (isCicle(h, val, key)) {
                            result.append("CICLE");
                            return result.toString();
                        }

                    } else if (!(h.containsKey(key))) {
                        h.put(key, val);//обертка
                        result.append(cl.getSimpleName() + ":{ " + myToString(value, h) + " }");
                        // result.append( " \n");
                    }
                }

                     */
            }
            cl = cl.getSuperclass();
        }
        return result.toString();
    }

    static class Wrapper {
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

    private static boolean isCicle(HashMap h, Wrapper value, Wrapper compValue) {
        if (compValue == value) {
            return true;
        }
        while (compValue != null) {
            Wrapper key = value;
            while (key != null) {
                key = (Wrapper) h.get(key);
                if (compValue == key) {
                    return true;
                }
            }
            compValue = (Wrapper) h.get(compValue);
        }
        return false;
    }
}

