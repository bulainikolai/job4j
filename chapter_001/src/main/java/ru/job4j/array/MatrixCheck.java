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
        for (int i = 0; i < data.length; i++) {
            //Проверка 1-й, потом 2-й диагонали на равенство 1-го значения диагонали остальным
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            } else if (data[0][data.length - 1] != data[i][data.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
