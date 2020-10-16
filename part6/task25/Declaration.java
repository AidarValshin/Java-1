package main.ru.mephi.java.part6.task25;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Comparator;
import java.util.List;


public class Declaration {
    public static String genericDeclaration(Method m) {
        StringBuilder sb = new StringBuilder();
        sb.append(Modifier.toString(m.getModifiers()));
        sb.append(" <");
        TypeVariable<Method>[] types = m.getTypeParameters();
        int i = 0;
        for (TypeVariable<Method> t : types) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(t);
            i++;
        }
        sb.append("> ");
        sb.append(m.getReturnType().getTypeName());
        sb.append(" ");
        sb.append(m.getName());
        sb.append("(");
        Type[] methodTypes = m.getGenericParameterTypes();
        i = 0;
        for (Type t : methodTypes) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(t.getTypeName());
            i++;
        }
        sb.append(")");

        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(genericDeclaration(main.ru.mephi.java.part6.task12_13.Arrays.class.getMethod("minmax", List.class, Comparator.class, List.class)));
    }
}
