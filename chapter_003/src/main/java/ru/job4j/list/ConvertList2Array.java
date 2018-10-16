package ru.job4j.list;

import java.util.*;

/**
 * ConvertList2Array
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 15.10.2018
 */
public class ConvertList2Array {

    /**
     * Method convert list to correct array
     * @param list what we convert
     * @param rows count of rows
     * @return array
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double) list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        Iterator<Integer> itr = list.iterator();
        for (int out = 0; out < rows; out++) {
            for (int in = 0; in < cells; in++) {
                if (itr.hasNext()) {
                    array[out][in] = itr.next();
                }
            }
        }
        return array;
    }

    /**
     * Convert List of arrays to list of integers
     * @param list contain List of arrays
     * @return list of integers
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int element : array) {
                result.add(element);
            }
        }
        return result;
    }
}
