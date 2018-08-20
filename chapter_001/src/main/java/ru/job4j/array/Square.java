package ru.job4j.array;

/**
 * Square
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 14.08.2018
 */
public class Square {

    /**
     * Method calculate
     * @param bound size of array numbers
     * @return array of squares of numbers
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int index = 0, m = 1; index < bound; index++, m++) {
            result[index] = (int) Math.pow(m, 2);
        }
        return result;
    }
}
