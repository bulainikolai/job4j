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
     * Method mono check similarity of diagonals
     * @param data array
     * @return boolean, result of comparison
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int index = 0; index < data.length; index++) {
            if (data[0][0] != data[index][index]) {
                result = false;
                break;
            } else if (data[0][data.length - 1] != data[index][data.length - 1 - index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
