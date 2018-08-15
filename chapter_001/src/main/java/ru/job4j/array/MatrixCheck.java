package ru.job4j.array;

/**
 * MatrixCheck
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 15.08.2018
 */
public class MatrixCheck {

    /**
     * Method mono check similarity of of diagonals
     * @param data array
     * @return boolean, result of comparison
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int n = data.length - 1;

        for (int i = 0; i < data.length; i++) {
            if (data.length % 2 != 0) {
                if (data[i][i] != data[i][n]) {
                    result = false;
                    break;
                } else {
                    n--;
                }
            } else if (data.length % 2 == 0) {
                if ((data[i][i] != data[i + 1][i + 1]) || (data[i][n] != data[i + 1][n - 1])) {
                    result = false;
                    break;
                } else {
                    if (data.length == i + 2) {
                        break;
                    }
                    n--;
                }
            }

        }
        return result;
    }
}
