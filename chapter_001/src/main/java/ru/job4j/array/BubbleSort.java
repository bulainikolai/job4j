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
            int couples = array.length - 1;
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                } else {
                    couples--;
                }
            }
            if (couples == 0) {
                break;
            }
        }
        return array;
    }
}
