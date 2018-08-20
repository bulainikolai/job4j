package ru.job4j.array;

/**
 * Matrix
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 14.08.2018
 */
public class Matrix {

    /**
     * Method multiple create a table of multiply
     * @param size amount of column
     * @return array like a table of multiply
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int out = 0; out < size; out++) {
            for (int in = 0; in < size; in++) {
                table[out][in] = (out + 1) * (in + 1);
            }
        }
        return table;
    }
}
