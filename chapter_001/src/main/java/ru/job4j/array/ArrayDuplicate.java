package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 15.08.2018
 */
public class ArrayDuplicate {

    /**
     * Method remove delete repeated elements
     * @param array with repeated elements
     * @return array without repeated elements
     */
    public String[] remove(String[] array) {

        int countOfRemoving = 0;
        String wrongString = "It is completely wrong string!!!";
        for (int i = 0; i < array.length; i++) {
            for (int m = i + 1; m < array.length; m++) {
                if (array[i].equals(array[m]) && !array[i].equals(wrongString)) {
                    array[m] = wrongString;
                    countOfRemoving++;
                }
            }
        }

        int countOfElements = array.length - countOfRemoving;
        while (true) {
            int numOfTurn = countOfElements;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].equals(wrongString)) {
                    array[i] = array[i + 1];
                    array[i + 1] = wrongString;
                } else {
                    numOfTurn--;
                }
            }
            if (numOfTurn == 0) {
                break;
            }
        }
        return Arrays.copyOf(array, countOfElements);
    }
}
