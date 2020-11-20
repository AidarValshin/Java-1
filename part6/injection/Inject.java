package main.ru.mephi.java.part6.injection;

import main.ru.mephi.java.Employee.Employee;
import main.ru.mephi.java.Employee.Manager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static main.ru.mephi.java.part6.injection.ClassDeclaration.getDeclarationClass;

public class Inject {
    /**
     * Check inject classes from "cls" to field "field" of Object o
     * check only classes with annotation TryInject
     *
     * @return true if it inject is possible
     */
    public static List<Class<?>> check(Object o, String field, List<Class<?>> cls) throws NoSuchFieldException {
        ArrayList<LinkedListType> arrayList1 = getDeclarationClass(o.getClass(), field);
        List<Class<?>> result = new ArrayList<>();
        for (Class<?> cl : cls) {
            if (cl.isAnnotationPresent(TryInject.class)) {
                if ((cl.getGenericSuperclass() instanceof Class)) {
                    if (checkClass(cl, arrayList1)) {
                        result.add(cl);
                    }
                } else {
                    Boolean resultFlag = checkParameterizedType(cl, arrayList1);
                    if (resultFlag == null) {
                        result.add(cl);
                    } else if (resultFlag) {
                        result.add(cl);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Check inject class  "cl" to field field produced by arrayLista
     *
     * @return true if it inject is possible
     */
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

    /**
     * @return Class of field from arrayList1.get(i2)
     */
    private static Class<?> getFieldClass(Class<?> fieldClass, ArrayList<LinkedListType> arrayList1, int i2) {
        try {
            fieldClass = Class.forName(arrayList1.get(i2).getType());
        } catch (ClassNotFoundException e) {
            System.out.println("check getDeclarationClass");
        }
        return fieldClass;
    }

    /**
     * @return assignable strict generic
     */
    private static boolean checkStrict(ArrayList<LinkedListType> arrayList1, Class<?> fieldClass, Class<?> parameter, int i) {
        if (arrayList1.get(i + 1).isUpLow())// Upper
        {
            return !fieldClass.isAssignableFrom(parameter);
        } else {
            return !parameter.isAssignableFrom(fieldClass);
        }
    }

    /**
     * Check assignable from cls to fieldClass
     *
     * @return true if it inject is possible
     */
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
        List<Class<?>> classes1 = Arrays.asList(MyPair1.class, MyPair2.class);
        check(testClass1, "pair", classes1).forEach(System.out::println);//MyPair1
        System.out.println("assert : MyPair1");

        System.out.println("---employees");
        List<Class<?>> classes2 = Arrays.asList(MyList1.class, MyList2.class, MyList5.class);
        check(testClass1, "employees", classes2).forEach(System.out::println);//MyList1,MyList5
        System.out.println("assert : MyList1,MyList5");

        System.out.println("---list2");
        List<Class<?>> classes3 = Arrays.asList(MyList3.class, MyList2.class, MyList4.class);
        check(testClass1, "list2", classes3).forEach(System.out::println);//MyList1,MyList5
        System.out.println("assert : MyList3.class");

        System.out.println("---list");
        List<Class<?>> classes4 = Arrays.asList(MyList3.class, MyList2.class, MyList4.class);
        check(testClass1, "list", classes4).forEach(System.out::println);
        System.out.println("assert : MyList3.class,MyList4.class");

        System.out.println("---employee");
        List<Class<?>> classes5 = Arrays.asList(Manager.class, Employee.class, Double.class, Object.class);
        check(testClass1, "employee", classes5).forEach(System.out::println);
        System.out.println("assert :Manager.class,Employee.class");
    }
}
