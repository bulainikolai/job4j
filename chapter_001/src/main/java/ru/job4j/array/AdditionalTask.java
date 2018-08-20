package ru.job4j.array;

import java.util.Arrays;

/**
 * AdditionalTask
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 19.08.2018
 */
public class AdditionalTask {

    /**
     * Method getNewArrayFromTwo создает из 2 отсортированных массивов 3-ий массив
     * @param first array
     * @param second array
     * @return отсортированный массив
     */
    public int[] getNewArrayFromTwo(int[] first, int[] second) {
        int count = first.length + second.length;
        int[] result = Arrays.copyOf(first, count);
        System.arraycopy(second, 0, result, first.length, second.length);
        while (true) {
            int changes = result.length - 1;
            for (int index = 0; index < result.length - 1; index++) {
                if (result[index] > result[index + 1]) {
                    int temp = result[index];
                    result[index] = result[index + 1];
                    result[index + 1] = temp;
                } else {
                    changes--;
                }
            }
            if (changes == 0) {
                break;
            }
        }
        return result;
    }
}
