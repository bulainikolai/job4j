package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * ConvertMatrix2List
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 16.10.2018
 */
public class ConvertMatrix2List {

    /**
     * Convert array into list
     * @param array we convert
     * @return list
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] out : array) {
            for (int in : out) {
                list.add(in);
            }
        }
        return list;
    }
}
