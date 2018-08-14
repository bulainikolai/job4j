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
        int[] rst = new int[bound];
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int i = 0, m = 1; i < bound; i++, m++) {
            rst[i] = (int) Math.pow(m, 2);
        }
        return rst;
    }
}
