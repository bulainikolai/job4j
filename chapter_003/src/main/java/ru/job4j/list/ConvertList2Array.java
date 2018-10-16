package ru.job4j.list;

import java.util.Iterator;
import java.util.List;

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
}
