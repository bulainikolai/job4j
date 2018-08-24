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
     * @return отсортированный по возрастанию массив
     */
    public int[] getNewArrayFromTwo(int[] first, int[] second) {
        int count = first.length + second.length;
        int[] result = new int[count];
        int elementOne = 0;
        int elementTwo = 0;
        int elementThree = 0;
        while (elementThree < count) {
            if (elementOne < first.length && elementTwo < second.length) {
                if (first[elementOne] < second[elementTwo]) {
                    result[elementThree] = first[elementOne];
                    elementOne++;
                } else {
                    result[elementThree] = second[elementTwo];
                    elementTwo++;
                }
            } else if (elementOne == first.length) {
                result[elementThree] = second[elementTwo];
                elementTwo++;
            } else if (elementTwo == second.length) {
                result[elementThree] = first[elementOne];
                elementOne++;
            }
            elementThree++;
        }
        return result;
    }
}
