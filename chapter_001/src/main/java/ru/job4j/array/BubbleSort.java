package ru.job4j.array;

/**
 * BubbleSort
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 14.08.2018
 */
public class BubbleSort {

    /**
     * Method sort array with a bubble method
     * @param array unsorted array
     * @return sorted array
     */
    public int[] sort(int[] array) {
        while (true) {
            int howManyTimes = array.length - 1;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                } else {
                    howManyTimes--;
                }
            }
            if (howManyTimes == 0) {
                break;
            }
        }
        return array;
    }
}
