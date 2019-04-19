package ru.job4j.loop;

/**
 * Factorial count factorial of even number
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 12.08.2018
 */
public class Factorial {

    /**
     * Method calc
     * @param n even number
     * @return factorial of number n
     */
    public int calc(int n) {
        int result = 1;
        for (int index = 1; index <= n; index++) {
            result *= index;
        }
        return result;
    }
}
