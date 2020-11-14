package main.ru.mephi.java.part6.injection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetTypes {
    /**
     * @return first LinkedListType of hierarchy types
     */
    public static LinkedListType getLinkedListType(WildcardType wildcardType, Map<String, String> map) {
        LinkedListType linkedListType = null;
        Type[] upper = wildcardType.getUpperBounds();
        Type[] lower = wildcardType.getLowerBounds();
        if (lower.length > 0 && lower[0] instanceof ParameterizedType) {
            linkedListType = setLinkedListNew(lower, false, map);
        } else if (upper.length > 0 && upper[0] instanceof ParameterizedType) {
            linkedListType = setLinkedListNew(upper, true, map);
        } else {
            if (lower.length > 0) {
                linkedListType = getLinkedListType(map, lower[0], false);
            } else if (upper.length > 0) {
                linkedListType = getLinkedListType(map, upper[0], true);
            }
        }
        return linkedListType;
    }

    private static LinkedListType getLinkedListType(Map<String, String> map, Type type, boolean b) {
        LinkedListType linkedListType;
        String description = type.getTypeName();
        description = checkReplaceFromMap(map, description);
        linkedListType = new LinkedListType(description, b, false);
        return linkedListType;
    }

    private static LinkedListType setLinkedListNew(Type[] types, boolean flag, Map<String, String> map) {
        ParameterizedType parameterizedType1 = (ParameterizedType) types[0];
        WildcardType wildcardType1 = (WildcardType) parameterizedType1.getActualTypeArguments()[0];
        String description = parameterizedType1
                .getRawType().getTypeName();
        description = checkReplaceFromMap(map, description);
        LinkedListType linkedListType = new LinkedListType(description, flag, false);
        getLinkedListType(wildcardType1, linkedListType, map);
        return linkedListType;
    }

    /**
     * If original contains subString= key from Map,
     * this substring will be replaced with value from Map
     *
     * @return replaced original
     */
    private static String checkReplaceFromMap(Map<String, String> map, String original) {
        if (map != null) {
            Pattern pattern;
            Matcher matcher;
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

    private static void setLinkedListNext(LinkedListType linkedListType, Type[] types, boolean flag, Map<String, String> map) {
        ParameterizedType parameterizedType1 = (ParameterizedType) types[0];
        setLinkedListTypeTypes(linkedListType, map, parameterizedType1.getRawType(), flag);
        linkedListType = linkedListType.getNext();
        WildcardType wildcardType1 = (WildcardType) parameterizedType1.getActualTypeArguments()[0];
        getLinkedListType(wildcardType1, linkedListType, map);
    }

    private static void getLinkedListType(WildcardType wildcardType, LinkedListType linkedListType, Map<String, String> map) {
        Type[] upper = wildcardType.getUpperBounds();
        Type[] lower = wildcardType.getLowerBounds();
        if (lower.length > 0 && lower[0] instanceof ParameterizedType) {
            setLinkedListNext(linkedListType, lower, false, map);
        } else if (upper.length > 0 && upper[0] instanceof ParameterizedType) {
            setLinkedListNext(linkedListType, upper, true, map);
        } else {
            if (lower.length > 0) {
                setLinkedListTypeTypes(linkedListType, map, lower[0], false);
            } else if (upper.length > 0) {
                setLinkedListTypeTypes(linkedListType, map, upper[0], true);
            }
        }
    }

    private static void setLinkedListTypeTypes(LinkedListType linkedListType, Map<String, String> map, Type type, boolean b) {
        String description = type.getTypeName();
        description = checkReplaceFromMap(map, description);
        linkedListType.setNext(description, b);
    }

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException {

        //  LinkedListType checkLinkedListType = getLinkedListType(wildcardType,map);
        Class clazz = Class.forName("main.ru.mephi.java.Employee.Employee");
        Class clazz1 = Class.forName("java.lang.Comparable");
        TestClass1 testClass1 = new TestClass1();
    }
}

