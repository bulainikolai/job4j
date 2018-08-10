package ru.job4j.max;

/**
 * Max return max number.
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 10.08.2018
 */
public class Max {

    /**
     * Method max.
     * @param first integer number.
     * @param second integer number.
     * @return a greater number of two number.
     */
    public int max(int first, int second) {
        return (first > second) ? first : second;
    }

    /**
     * Method max return of three numbers
     * @param first integer number.
     * @param second integer number.
     * @param third integer number.
     * @return a greater number of three number.
     */
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        return this.max(temp, third);
    }
}
