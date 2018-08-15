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
        for (int i = 0; i < size; i++) {
            for (int m = 0; m < size; m++) {
                table[i][m] = (i + 1) * (m + 1);
            }
        }
        return table;
    }
}
