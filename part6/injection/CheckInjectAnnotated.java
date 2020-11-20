package main.ru.mephi.java.part6.injection;

import java.util.List;

public class CheckInjectAnnotated {
    /**
     * @return list of classes that can be injected in field "field" of class "o"
     */
    public static List<Class<?>> list(Object o, String field) throws ClassNotFoundException, NoSuchFieldException {
        List<Class<?>> list = GetAllClassesFromClassPaths.getAllClasses();
        return Inject.check(o, field, list);
    }

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException {
        TestClass1 testClass1 = new TestClass1();
        System.out.println("---pair");
        list(testClass1, "pair").forEach(System.out::println);
        System.out.println("assert : MyPair1");

        System.out.println("---employees");
        list(testClass1, "employees").forEach(System.out::println);
        System.out.println("assert : MyList1,MyList5");

        System.out.println("---list2");
        list(testClass1, "list2").forEach(System.out::println);
        System.out.println("assert : MyList3.class");

        System.out.println("---list");
        list(testClass1, "list").forEach(System.out::println);
        System.out.println("assert : MyList3.class,MyList4.class");

        System.out.println("---employee");
        list(testClass1, "employee").forEach(System.out::println);
        System.out.println("assert :Manager.class,Employee.class");
    }

}


