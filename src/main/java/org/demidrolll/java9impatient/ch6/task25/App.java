package org.demidrolll.java9impatient.ch6.task25;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

/**
 * Write a method public static String genericDeclaration(Method m) that returns
 * the declaration of the method m listing the type parameters with their
 * bounds and the types of the method parameters, including their type
 * arguments if they are generic types.
 */

public class App {

    public static void main(String[] args) throws NoSuchMethodException {
        String desc = genericDeclaration(App.class.getMethod("main", String[].class));
        System.out.println(desc);

        desc = genericDeclaration(App.class.getMethod("simpleGeneric", List.class));
        System.out.println(desc);

        desc = genericDeclaration(App.class.getMethod("boundedGeneric"));
        System.out.println(desc);
    }

    public static <T> T simpleGeneric(List<T> list) {
        return null;
    }

    public static <T extends List<E>, E extends Number> List<E> boundedGeneric() {
        return null;
    }

    public static String genericDeclaration(Method m) {
        StringBuilder desc = new StringBuilder();
        desc.append(Modifier.toString(m.getModifiers()));
        desc.append(" ");
        TypeVariable<Method>[] vars = m.getTypeParameters();
        if (vars.length > 0) {
            desc.append("<");
            Arrays.stream(vars).forEach(v -> {
                desc.append(v.getName());
                desc.append(", ");
            });
            int deleteInd = desc.lastIndexOf(", ");
            desc.delete(deleteInd, deleteInd + 2);
            desc.append(">");
            desc.append(" ");
        }
        Type returnType = m.getGenericReturnType();
        desc.append(returnType.getTypeName());
        desc.append(" ");
        desc.append(m.getName());
        desc.append("(");
        Arrays.stream(m.getParameters()).forEach(p -> {
            desc.append(p.getType().getSimpleName());
            desc.append(" ");
            desc.append(p.getName());
        });
        desc.append(")");
        return desc.toString();
    }

}
