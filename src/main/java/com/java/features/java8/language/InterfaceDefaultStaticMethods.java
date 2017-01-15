package com.java.features.java8.language;

/**
 * Created by krishna.m1 on 13/01/17.
 *
 * Default and Static methods in Java 1.8 interfaces example.
 */
public class InterfaceDefaultStaticMethods {

    private interface Java8Interface {
        void normalInterfaceMethod();
        default String initDefaultMethod() {
            return "Java8 Default Method";
        }
    }

    /**
     * Default method of the interface is accessible by all
     * sub-classes.
     * @param java8Interface {@link Java8Interface} type
     */
    private static void invokeDefaultMethod(Java8Interface java8Interface) {
        System.out.println(java8Interface.initDefaultMethod());
    }

    public static void main(String args[]) {
        Java8Interface java8Interface = () -> System.out.println("Normal interface method!");
        invokeDefaultMethod(java8Interface);

        /**
         * Normal way of invoking the interface method, which is similar
         * to the old Java style.
         */
        java8Interface.normalInterfaceMethod();
    }
}
