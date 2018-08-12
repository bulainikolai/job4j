package ru.job4j.loop;

/**
 * Factorial count factorial of even number
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @sinse 12.08.2018
 */
public class Factorial {

    /**
     * Method calc
     * @param n even number
     * @return factorial of number n
     */
    public int calc(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }
}
