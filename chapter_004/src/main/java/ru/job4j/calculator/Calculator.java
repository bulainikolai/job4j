package ru.job4j.calculator;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Calculator
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 22.11.2018
 */
public class Calculator {

    /**
     * Main method
     * @param start int
     * @param finish int
     * @param value int
     * @param op object of interface BiFunction
     * @param media object of interface Consumer
     */
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    /**
     * Check of multiple
     * @param args
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 10, 2,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Multiple %s * %s = %s %n", value, index, result);
                    return result;
                },
                result -> System.out.println(result)
        );
    }
}
