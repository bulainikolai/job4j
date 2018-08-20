package ru.job4j.array;


/**
 * FindLoop
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 14.08.2018
 */
public class FindLoop {

    /**
     * Method
     * @param data array with datas
     * @param el element?, which has tj be found
     * @return index of array's element
     */
    public int indexOf(int[] data, int el) {
        int resalt = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                resalt = index;
                break;
            }
        }
        return resalt;
    }
}
