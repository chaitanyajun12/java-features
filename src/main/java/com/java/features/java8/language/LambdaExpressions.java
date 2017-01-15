package com.java.features.java8.language;

/**
 * Created by krishna.m1 on 13/01/17.
 *
 * Java 1.8 : Lamda expressions and Functional Interfaces example.
 */
public class LambdaExpressions {
    public static void main(String args[]) {
        /**
         *  Prior to Java 8
         *  Using Anonymous classes
         */
        compareStrings(new FooInterface() {
            @Override
            public void printFoo() {
                System.out.println("Java old style : Using anonymous classes!");
            }
        });

        /**
         *  In Java 8
         *  Using Lambda expressions and Functional Interfaces
         */
        compareStrings(() -> System.out.println("Java new style : Using Lambda expressions!"));
        compareStrings(() -> {
            System.out.println("Java new style : Using Lambda expressions, multi-line methods!");
            System.out.println("Multiple lines are possible!");
        });
    }

    static void compareStrings(FooInterface stringComparator) {
        stringComparator.printFoo();
    }

    /**
     *  To make the interface Lambda friendly its safe to have
     *  @FunctionalInterface annotation to this interface, provided
     *  this interface will have only one method. An interface with a
     *  single method can be converted to lambda expression. So, this
     *  annotation can be considered as safe check at compile time.
     */
    @FunctionalInterface
    public interface FooInterface {
        void printFoo();
    }
}
