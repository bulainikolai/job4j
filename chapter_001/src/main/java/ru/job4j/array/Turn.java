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
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            int last = array.length - (index + 1);
            array[index] = array[last];
            array[last] = temp;
        }
        return array;
    }
}
