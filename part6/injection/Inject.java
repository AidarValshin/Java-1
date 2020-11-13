package main.ru.mephi.java.part6.injection;

import main.ru.mephi.java.Employee.Employee;
import main.ru.mephi.java.Employee.Manager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static main.ru.mephi.java.part6.injection.ClassDeclaration.getDeclarationClass;

public class Inject {
    /**
     * Check inject "cls" to field "field" of Object o
     *
     * @return true if it inject is possible
     */
    public static boolean check(Object o, String field, Class<?> cls) throws NoSuchFieldException {
        ArrayList<LinkedListType> arrayList1 = getDeclarationClass(o.getClass(), field);
        Class<?> fieldClass = null;
        if ((cls.getGenericSuperclass() instanceof Class)) {
            try {
                fieldClass = Class.forName(arrayList1.get(0).getType());
            } catch (ClassNotFoundException e) {
                System.out.println("check getDeclarationClass");
            }
            if (!fieldClass.isAssignableFrom(cls)) {
                return false;
            }
        } else {
            ParameterizedType type = (ParameterizedType) cls.getGenericSuperclass();
            Type[] types = type.getActualTypeArguments();

            try {
                fieldClass = Class.forName(arrayList1.get(0).getType());
            } catch (ClassNotFoundException e) {
                System.out.println("check getDeclarationClass");
            }
            assert fieldClass != null;
            if (!fieldClass.isAssignableFrom(cls)) {
                return false;
            }
            Class<?> parameter;
            for (int i = 0; i < types.length; i++) {
                parameter = (Class<?>) types[i];
                try {
                    fieldClass = Class.forName(arrayList1.get(i + 1).getType());
                } catch (ClassNotFoundException e) {
                    System.out.println("check getDeclarationClass");
                }
                if (!arrayList1.get(i + 1).isStrict()) {
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
                } else {
                    if (!fieldClass.equals(parameter)) {
                        return false;
                    }
                }
                LinkedListType typeNext = arrayList1.get(i + 1).getNext();
                if (!checkClassHierarchially(typeNext, parameter)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check accessible "parameter" to/from typeNext.getType class
     *
     * @return true if accessible
     */
    private static boolean checkClassHierarchially(LinkedListType typeNext, Class<?> parameter) {
        if (typeNext != null) {
            Class<?> fieldClass = null;
            try {
                fieldClass = Class.forName(typeNext.getType());
            } catch (ClassNotFoundException e) {
                System.out.println("check getDeclarationClass");
            }
            if (!typeNext.isStrict()) {
                if (typeNext.isUpLow())// Upper
                {
                    assert fieldClass != null;
                    if (!fieldClass.isAssignableFrom(parameter)) {
                        return false;
                    }
                } else {
                    if (parameter.getSuperclass() != Object.class) {
                        parameter = parameter.getSuperclass();
                    }
                    assert fieldClass != null;
                    if (!parameter.isAssignableFrom(fieldClass)) {
                        return false;
                    }
                }
            } else {
                if (!fieldClass.equals(parameter)) {
                    return false;
                }
            }
            typeNext = typeNext.getNext();
            if (!checkClassHierarchially(typeNext, parameter)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        TestClass1 testClass1 = new TestClass1();
        System.out.println("---pair");
        System.out.println(check(testClass1, "pair", MyPair1.class));//true
        System.out.println(check(testClass1, "pair", MyPair2.class));//false
        System.out.println("---employees");
        System.out.println(check(testClass1, "employees", MyList1.class));//true
        System.out.println(check(testClass1, "employees", MyList2.class));//false
        System.out.println("---list2");
        System.out.println(check(testClass1, "list2", MyList3.class));//true
        System.out.println(check(testClass1, "list2", MyList4.class));//false
        System.out.println(check(testClass1, "list2", MyList2.class));//false
        System.out.println("---list");
        System.out.println(check(testClass1, "list", MyList3.class));//true
        System.out.println(check(testClass1, "list", MyList4.class));//true
        System.out.println(check(testClass1, "list", MyList2.class));//false
        System.out.println("---employee");
        System.out.println(check(testClass1, "employee", Manager.class));//true
        System.out.println(check(testClass1, "employee", Employee.class));//true
        System.out.println(check(testClass1, "employee", Double.class));//false
    }
}
