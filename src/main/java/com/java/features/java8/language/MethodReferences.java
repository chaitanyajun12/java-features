package com.java.features.java8.language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * Created by krishna.m1 on 16/01/17.
 *
 * Method references can be used, where ever, there is a
 * Lambda expression calling only a single method.
 *
 * If there is an Anonymous class -> it can be converted to
 * Lambda expression. If the Lambda expression calls only a single
 * method in its implementation -> it can be convereted to
 * a Method reference.
 */
public class MethodReferences {
    public static boolean isGreaterThan(int num, int n) {
        return num > n;
    }

    private static List<Integer> findNumbers(List<Integer> integerList, BiPredicate<Integer, Integer> predicate) {
        List<Integer> list = new ArrayList<>();
        for (Integer integer : integerList) {
            if (predicate.test(integer, 10)) {
                list.add(integer);
            }
        }
        return list;
    }


    class PercentEngine {
        public boolean calculatePercentage(int goodsCount) {
            return goodsCount > 10;
        }
    }

    public List<Integer> percentageOnGoods(List<Integer> goodsList,
                                                 BiPredicate<PercentEngine, Integer> predicate) {
        List<Integer> list = new ArrayList<>();
        PercentEngine percentEngine = new PercentEngine();

        for (Integer integer : goodsList) {
            if (predicate.test(percentEngine, integer)) {
                list.add(integer);
            }
        }
        return list;
    }

    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(10, 11, 12, 15, 9, 2, 19, 20);

        System.out.println("(1) Static method reference");
        /**
         * Lambda expression
         */
        System.out.println(
                findNumbers(list, (i, k) -> isGreaterThan(i, k)).toString()
        );

        /**
         * Static method reference
         * Since, there is only a single method. We can convert above Lambda
         * expression to a Method reference.
         */
        System.out.println(
            findNumbers(list, MethodReferences::isGreaterThan).toString()
        );

        System.out.println("(2) Instance method reference of an object of a particular type");
        MethodReferences methodReferences = new MethodReferences();
        /**
         * Lambda expression
         * First argument is an instance which calls a method
         * within it.
         */
        System.out.println(
            methodReferences.percentageOnGoods(list, (p, k) -> p.calculatePercentage(k))
        );

        /**
         * Instance method reference of an object of a
         * particular type.
         */
        System.out.println(
                methodReferences.percentageOnGoods(list, PercentEngine::calculatePercentage)
        );


    }
}
