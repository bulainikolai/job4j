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
        int countOfElements = first.length + second.length;
        int[] result = Arrays.copyOf(first, countOfElements);
        System.arraycopy(second, 0, result, first.length, second.length);
        while (true) {
            int changes = result.length - 1;
            for (int i = 0; i < result.length - 1; i++) {
                if (result[i] > result[i + 1]) {
                    int temp = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = temp;
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
