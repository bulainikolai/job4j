package ru.job4j.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Diapason
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 23.11.2018
 */
public class Diapason {
    /**
     * Proto function
     * @param start first
     * @param end count of dots
     * @param func general tipe of function
     * @return list of dots
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index <= end; index++) {
            result.add(func.apply(new Double(index)));
        }
        return result;
    }

    /**
     * linearFunction
     * @param start first dot
     * @param end count of dots
     * @return list of dots
     */
    public List<Double> linearFunction(int start, int end) {
        return this.diapason(start, end, n -> 2 * n + 3);
    }

    /**
     * quadraticFunction
     * @param start first dot
     * @param end count of dots
     * @return list of dots
     */
    public List<Double> quadraticFunction(int start, int end) {
        return this.diapason(start, end, n -> 2 * Math.pow(n, 2) + 3 * n - 5);
    }

    /**
     * logarithmicFunction
     * @param start first dot
     * @param end count of dots
     * @return list of dots
     */
    public List<Double> logarithmicFunction(int start, int end) {
        return this.diapason(start, end, n -> Math.ceil(Math.log(n) * 100) / 100);
    }

}
