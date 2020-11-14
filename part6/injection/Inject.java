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
        if ((cls.getGenericSuperclass() instanceof Class)) {
            return checkClass(cls, arrayList1);
        } else {
            Boolean result = checkParameterizedType(cls, arrayList1);
            if (result != null) return result;
        }
        return true;
    }

    private static Boolean checkParameterizedType(Class<?> cls, ArrayList<LinkedListType> arrayList1) {
        Class<?> fieldClass = null;
        ParameterizedType type = (ParameterizedType) cls.getGenericSuperclass();
        if (type != null) {
            Type[] types = type.getActualTypeArguments();
            fieldClass = getFieldClass(null, arrayList1, 0);
            assert fieldClass != null;
            if (checkUpperNotStrict(fieldClass, fieldClass.isAssignableFrom(cls))) return false;
            Class<?> parameter;
            for (int i = 0; i < types.length; i++) {
                if (types[i] instanceof Class<?>) {
                    parameter = (Class<?>) types[i];
                    fieldClass = getFieldClass(fieldClass, arrayList1, i + 1);
                    if (!arrayList1.get(i + 1).isStrict()) {
                        if (checkStrict(arrayList1, fieldClass, parameter, i)) return false;
                    } else {
                        if (!fieldClass.equals(parameter)) {
                            return false;
                        }
                    }
                    LinkedListType typeNext = arrayList1.get(i + 1).getNext();
                    if (!checkClassHierarchically(typeNext, parameter)) {
                        return false;
                    }
                } else if (types[i] instanceof ParameterizedType) {
                    return checkClassHierarchicallyParametrized(arrayList1, types, i);
                }
            }
        } else {
            return checkClass(cls, arrayList1);
        }
        return null;
    }

    private static Class<?> getFieldClass(Class<?> fieldClass, ArrayList<LinkedListType> arrayList1, int i2) {
        try {
            fieldClass = Class.forName(arrayList1.get(i2).getType());
        } catch (ClassNotFoundException e) {
            System.out.println("check getDeclarationClass");
        }
        return fieldClass;
    }

    private static boolean checkStrict(ArrayList<LinkedListType> arrayList1, Class<?> fieldClass, Class<?> parameter, int i) {
        if (arrayList1.get(i + 1).isUpLow())// Upper
        {
            return !fieldClass.isAssignableFrom(parameter);
        } else {
            return !parameter.isAssignableFrom(fieldClass);
        }
    }

    private static boolean checkClass(Class<?> cls, ArrayList<LinkedListType> arrayList1) {
        Class<?> fieldClass = getFieldClass(arrayList1.get(0));
        assert fieldClass != null;
        return fieldClass.isAssignableFrom(cls);
    }

    /**
     * Check accessible "parameter" to/from typeNext.getType class
     *
     * @return true if accessible
     */
    private static boolean checkClassHierarchically(LinkedListType typeNext, Class<?> parameter) {
        if (typeNext != null) {
            Class<?> fieldClass = getFieldClass(typeNext);
            assert fieldClass != null;
            if (!typeNext.isStrict()) {
                if (typeNext.isUpLow())// Upper
                {
                    if (checkUpperNotStrict(fieldClass, fieldClass.isAssignableFrom(parameter))) return false;
                } else {
                    if (parameter.getSuperclass() != Object.class && parameter != Object.class) {
                        parameter = parameter.getSuperclass();
                    }
                    if (checkUpperNotStrict(fieldClass, parameter.isAssignableFrom(fieldClass))) return false;
                }
            } else {
                if (!fieldClass.equals(parameter)) {
                    return false;
                }
            }
            typeNext = typeNext.getNext();
            return checkClassHierarchically(typeNext, parameter);
        }
        return true;
    }

    private static boolean checkUpperNotStrict(Class<?> fieldClass, boolean assignableFrom) {
        assert fieldClass != null;
        return !assignableFrom;
    }

    private static boolean checkClassHierarchicallyParametrized(ArrayList<LinkedListType> typeNextArray
            , Type[] types, int i) {
        LinkedListType typeNext = typeNextArray.get(i + 1);
        Type type = types[i];
        if (typeNext != null) {
            Class<?> parameter = getParameter((ParameterizedType) type);
            Class<?> fieldClass = getFieldClass(typeNext);
            if (!typeNext.isStrict()) {
                if (checkNotStrictParameterized(typeNext, parameter, fieldClass)) return false;
            } else {
                assert fieldClass != null;
                if (!fieldClass.equals(parameter)) {
                    return false;
                }
            }
            typeNext = typeNext.getNext();
            type = getType(types, i, type);
            if (type instanceof ParameterizedType) {
                Boolean result = checkParameterizedType(typeNext, (ParameterizedType) type);
                if (result != null) return result;
            } else {
                return checkClassHierarchically(typeNext, (Class<?>) type);
            }
        }
        return true;
    }

    private static boolean checkNotStrictParameterized(LinkedListType typeNext, Class<?> parameter, Class<?> fieldClass) {
        if (typeNext.isUpLow())// Upper
        {
            assert fieldClass != null;
            assert parameter != null;
            return checkUpperNotStrict(parameter, fieldClass.isAssignableFrom(parameter));
        } else {
            assert parameter != null;
            assert fieldClass != null;
            return checkLow(parameter, fieldClass);
        }
    }

    private static Boolean checkParameterizedType(LinkedListType typeNext, ParameterizedType type) {
        Class<?> parameter;
        if (typeNext != null) {
            String description = type
                    .getRawType().getTypeName();
            parameter = null;
            try {
                parameter = Class.forName(description);
            } catch (ClassNotFoundException e) {
                System.out.println("check checkClassHierarchicallyParametrized");
            }
            return checkClassHierarchically(typeNext, parameter);
        }
        return null;
    }

    private static Type getType(Type[] types, int i, Type type) {
        if (types.length == i + 1) {
            type = ((ParameterizedType) type).getActualTypeArguments()[0];
        } else {
            type = types[++i];
        }
        return type;
    }

    private static boolean checkLow(Class<?> parameter, Class<?> fieldClass) {
        if (parameter.getSuperclass() != Object.class) {
            parameter = parameter.getSuperclass();
        }
        return checkUpperNotStrict(fieldClass, parameter.isAssignableFrom(fieldClass));
    }

    private static Class<?> getFieldClass(LinkedListType typeNext) {
        Class<?> fieldClass = null;
        try {
            fieldClass = Class.forName(typeNext.getType());
        } catch (ClassNotFoundException e) {
            System.out.println("check getDeclarationClass");
        }
        return fieldClass;
    }

    private static Class<?> getParameter(ParameterizedType type) {
        String description = type
                .getRawType().getTypeName();
        Class<?> parameter = null;
        try {
            parameter = Class.forName(description);
        } catch (ClassNotFoundException e) {
            System.out.println("check checkClassHierarchicallyParametrized");
        }
        return parameter;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        TestClass1 testClass1 = new TestClass1();
        System.out.println("---pair");
        System.out.println("true = " + check(testClass1, "pair", MyPair1.class));//true
        System.out.println("false = " + check(testClass1, "pair", MyPair2.class));//false
        System.out.println("---employees");
        System.out.println("true = " + check(testClass1, "employees", MyList1.class));//true
        System.out.println("false = " + check(testClass1, "employees", MyList2.class));//false
        System.out.println("true = " + check(testClass1, "employees", MyList5.class));//true
        System.out.println("---list2");
        System.out.println("true = " + check(testClass1, "list2", MyList3.class));//true
        System.out.println("false = " + check(testClass1, "list2", MyList4.class));//false
        System.out.println("false = " + check(testClass1, "list2", MyList2.class));//false
        System.out.println("---list");
        System.out.println("true = " + check(testClass1, "list", MyList3.class));//true
        System.out.println("true = " + check(testClass1, "list", MyList4.class));//true
        System.out.println("false = " + check(testClass1, "list", MyList2.class));//false
        System.out.println("---employee");
        System.out.println("true = " + check(testClass1, "employee", Manager.class));//true
        System.out.println("true = " + check(testClass1, "employee", Employee.class));//true
        System.out.println("false = " + check(testClass1, "employee", Double.class));//false
        System.out.println("false = " + check(testClass1, "employee", Object.class));//false
    }
}
