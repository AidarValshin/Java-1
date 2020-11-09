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
                String description = lower[0].getTypeName();
                description = checkReplaceFromMap(map, description);
                linkedListType = new LinkedListType(description, false);
            } else if (upper.length > 0) {
                String description = upper[0].getTypeName();
                description = checkReplaceFromMap(map, description);
                linkedListType = new LinkedListType(description, true);
            }
        }
        return linkedListType;
    }

    private static LinkedListType setLinkedListNew(Type[] types, boolean flag, Map<String, String> map) {
        ParameterizedType parameterizedType1 = (ParameterizedType) types[0];
        WildcardType wildcardType1 = (WildcardType) parameterizedType1.getActualTypeArguments()[0];
        String description = parameterizedType1
                .getRawType().getTypeName();
        description = checkReplaceFromMap(map, description);
        LinkedListType linkedListType = new LinkedListType(description, flag);
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
        String description = parameterizedType1.getRawType().getTypeName();
        description = checkReplaceFromMap(map, description);
        linkedListType.setNext(description, flag);
        linkedListType = linkedListType.getNext();
        WildcardType wildcardType1 = (WildcardType) parameterizedType1.getActualTypeArguments()[0];
        getLinkedListType(wildcardType1, linkedListType, map);
    }

    private static LinkedListType getLinkedListType(WildcardType wildcardType, LinkedListType linkedListType, Map<String, String> map) {
        LinkedListType oldLinkedListType = linkedListType;
        Type[] upper = wildcardType.getUpperBounds();
        Type[] lower = wildcardType.getLowerBounds();
        if (lower.length > 0 && lower[0] instanceof ParameterizedType) {
            setLinkedListNext(linkedListType, lower, false, map);
        } else if (upper.length > 0 && upper[0] instanceof ParameterizedType) {
            setLinkedListNext(linkedListType, upper, true, map);
        } else {
            if (lower.length > 0) {
                String description = lower[0].getTypeName();
                description = checkReplaceFromMap(map, description);
                linkedListType.setNext(description, false);
            } else if (upper.length > 0) {
                String description = upper[0].getTypeName();
                description = checkReplaceFromMap(map, description);
                linkedListType.setNext(description, true);
            }
        }
        return oldLinkedListType;
    }

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException {

        //  LinkedListType checkLinkedListType = getLinkedListType(wildcardType,map);
        Class clazz = Class.forName("main.ru.mephi.java.Employee.Employee");
        Class clazz1 = Class.forName("java.lang.Comparable");
        TestClass1 testClass1 = new TestClass1();
    }
}

