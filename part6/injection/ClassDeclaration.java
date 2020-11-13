package main.ru.mephi.java.part6.injection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static main.ru.mephi.java.part6.injection.GetTypes.getLinkedListType;

public class ClassDeclaration {
    /**
     * Get hierarchically types of parameters
     * @return ArrayList<LinkedListType>
     */
    public static ArrayList<LinkedListType> getDeclarationClass(Class clazz, String field) throws NoSuchFieldException {
        Map<String, String> map = typeBounds(clazz); // get type variables of clazz with type bounds
        Field f = clazz.getDeclaredField(field);
        f.setAccessible(true);
        ArrayList<LinkedListType> arrayList = new ArrayList<>(3);
        arrayList.add(LinkedListType.setInitalParent(f.getType().getTypeName()));
        if (!(f.getGenericType() instanceof Class)) {
            ParameterizedType parameterizedType = (ParameterizedType) f.getGenericType();
            String typeName;
            for (int j = 0; j != parameterizedType.getActualTypeArguments().length; j++) {
                typeName = parameterizedType.getActualTypeArguments()[j].getTypeName();
                typeName = checkReplaceFromMap(map, typeName);
                if (parameterizedType.getActualTypeArguments()[j] instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) parameterizedType.getActualTypeArguments()[j];
                    arrayList.add(getLinkedListType(wildcardType, map));
                } else {
                    arrayList.add(new LinkedListType(typeName, true,true));
                }
            }
        }
        return arrayList;
    }
//the same as higher but with print
    public static void getDeclarationClasses(Class clazz) {
        Map<String, String> map = typeBounds(clazz);
        if (map != null) {
            map.forEach((k, v) -> System.out.println("TypeParam-> " + k + " ,Type-> " + v));
        } else {
            System.out.println("no typeParameter");
        }
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println();
            System.out.println(f.getType());
            ArrayList<LinkedListType> arrayList = new ArrayList<>(3);
            arrayList.add(LinkedListType.setInitalParent(f.getType().getTypeName()));
            if (!(f.getGenericType() instanceof Class)) {
                ParameterizedType parameterizedType = (ParameterizedType) f.getGenericType();
                String typeName;
                for (int j = 0; j != parameterizedType.getActualTypeArguments().length; j++) {
                    typeName = parameterizedType.getActualTypeArguments()[j].getTypeName();
                    typeName = checkReplaceFromMap(map, typeName);
                    System.out.println(typeName);
                    if (parameterizedType.getActualTypeArguments()[j] instanceof WildcardType) {
                        WildcardType wildcardType = (WildcardType) parameterizedType.getActualTypeArguments()[j];
                        arrayList.add(getLinkedListType(wildcardType, map));
                        Type[] upper = wildcardType.getUpperBounds();
                        Type[] lower = wildcardType.getLowerBounds();
                        if (lower.length > 0) {
                            String description = lower[0].getTypeName();
                            description = checkReplaceFromMap(map, description);
                            System.out.println("lower: " + description);
                        } else if (upper.length > 0) {
                            String description = upper[0].getTypeName();
                            description = checkReplaceFromMap(map, description);
                            System.out.println("upper: " + description);
                        }
                    } else {
                        arrayList.add(new LinkedListType(typeName, true,true));
                    }
                }
            }
            System.out.println("linked");
            arrayList.forEach(p -> System.out.println(p));
        }
    }

    /**
     * @return  null or type bound of generic type in JVM
     */
    private static Map<String, String> typeBounds( Class<?> cl) {
        String description = null;
        Map<String, String> result = null;
        TypeVariable<?>[] vars = cl.getTypeParameters();
        if (vars.length != 0) {
            result = new HashMap<>(vars.length);
            for (TypeVariable var : vars) {
                Type[] bounds = var.getBounds();
                if (bounds[0] instanceof ParameterizedType) {
                    ParameterizedType p = (ParameterizedType) bounds[0];
                    Type[] typeArguments = p.getActualTypeArguments();
                    if (typeArguments[0] instanceof WildcardType) {
                        WildcardType t = (WildcardType) typeArguments[0];
                        Type[] upper = t.getUpperBounds();
                        Type[] lower = t.getLowerBounds();
                        if (lower.length > 0) {
                            description = lower[0].getTypeName();
                        } else if (upper.length > 0) {
                            description = upper[0].getTypeName();
                        }
                    }

                } else {
                    description = bounds[0].getTypeName();
                }
                result.put(var.getName(), description);
            }
        }
        return result;
    }

    /**
     * If original contains subString= key from Map,
     * this substring will be replaced with value from Map
     *
     * @return replaced original
     */
    private static String checkReplaceFromMap(Map<String, String> map, String original) {
        if (map != null) {
            Pattern pattern = null;
            Matcher matcher = null;
            for (String key : map.keySet()) {
                pattern = Pattern.compile("\\b" + key + "\\b");
                matcher = pattern.matcher(original);
                if (matcher.find()) {
                    original = matcher.replaceAll(map.get(key));
                    break;
                }
            }
        }
        return original;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        TestClass1 testClass1 = new TestClass1();
        ArrayList<LinkedListType> arrayList1 = getDeclarationClass(testClass1.getClass(), "list2");
        arrayList1.forEach(p -> System.out.println(p));
        System.out.println();
        ArrayList<LinkedListType> arrayList2 = getDeclarationClass(testClass1.getClass(), "a");
        arrayList2.forEach(p -> System.out.println(p));
        System.out.println();
        ArrayList<LinkedListType> arrayList3 = getDeclarationClass(testClass1.getClass(), "list");
        arrayList3.forEach(p -> System.out.println(p));
        System.out.println();
        ArrayList<LinkedListType> arrayList4 = getDeclarationClass(testClass1.getClass(), "employees");
        arrayList4.forEach(p -> System.out.println(p));
        System.out.println();
        ArrayList<LinkedListType> arrayList5 = getDeclarationClass(testClass1.getClass(), "pair");
        arrayList5.forEach(p -> System.out.println(p));
        System.out.println();
        ArrayList<LinkedListType> arrayList6 = getDeclarationClass(testClass1.getClass(), "types");
        arrayList6.forEach(p -> System.out.println(p));
        //  System.out.println();
        //  getDeclarationClasses(testClass1.getClass());


    }
}
