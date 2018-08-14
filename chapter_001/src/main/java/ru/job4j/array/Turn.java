package ru.job4j.array;

/**
 * Turn
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 14.08.2018
 */
public class Turn {

    /**
     * Method turn invert array
     * @param array
     * @return inverted array
     */
    public int[] turn(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            int lastIndex = array.length - (i + 1);
            array[i] = array[lastIndex];
            array[lastIndex] = temp;
        }
        return array;
    }
}
