package main.ru.mephi.java.part6.injection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static main.ru.mephi.java.part6.injection.ClassDeclaration.getDeclarationClass;

public class Inject {
    /**
     * Check inject "cls" to field "field" of Object o
     * @return true if it inject is possible
     */
    public static boolean check(Object o, String field, Class<?> cls) throws NoSuchFieldException {
        ArrayList<LinkedListType> arrayList1 = getDeclarationClass(o.getClass(), field);

        ParameterizedType type = (ParameterizedType) cls.getGenericSuperclass();
        Type[] types = type.getActualTypeArguments();

        Class<?> fieldClass = null;
        try {
            fieldClass = Class.forName(arrayList1.get(0).getType());
        } catch (ClassNotFoundException e) {
            System.out.println("check getDeclarationClass");
        }
        if (!fieldClass.isAssignableFrom(cls)) {
            return false;
        }
        Class<?> parameter;
        for (int i = 0; i < types.length; i++) {
            parameter = (Class) type.getActualTypeArguments()[i];
            try {
                fieldClass = Class.forName(arrayList1.get(i + 1).getType());
            } catch (ClassNotFoundException e) {
                System.out.println("check getDeclarationClass");
            }
            if (arrayList1.get(i + 1).isUpLow())// Upper
            {
                if (!fieldClass.isAssignableFrom(parameter)) {
                    return false;
                }
            } else {
                if (!parameter.isAssignableFrom(fieldClass)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        TestClass1 testClass1 = new TestClass1();
        System.out.println(check(testClass1, "pair", MyPair1.class));
        System.out.println(check(testClass1, "pair", MyPair2.class));
    }
}
