package ru.job4j.task;

import java.util.*;

/**
 * Departments
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 22.11.2018
 */
public class Departments {

    /**
     * Fill array missing departments
     * @param data array with departments
     * @return correct array
     */
    public Set<String> fillArray(String[] data) {
        Set<String> check = new TreeSet<>();
        for (String currentString : data) {
            int nextIndex = 0;
            for (int i = 0; i < currentString.split("/").length; i++) {
                int index = currentString.indexOf("/", nextIndex);
                if (index == -1) {
                    check.add(currentString);
                } else {
                    check.add(currentString.substring(0, index));
                    nextIndex = index + 1;
                }
            }
        }
        return check;
    }

    /**
     * Sort departments by literal comparison
     * @param data array with departments
     * @return sorted array
     */
    public String[] sortDepartmentsStraight(String[] data) {
        Set<String> check = fillArray(data);
        String[] result = new String[check.size()];
        return check.toArray(result);
    }

    /**
     * Sort departments by literal comparison from back to start
     * @param data array with departments
     * @return sorted array
     */
    public String[] sortDepartmentsBack(String[] data) {
        List<String> list = new ArrayList<>(fillArray(data));
        Set<String> keys = new TreeSet<>((s1, s2) -> s2.compareTo(s1));
        for (String str : list) {
            keys.add(str.substring(0, 2));
        }
        List<String> correct = new ArrayList<>();
        for (String strKey : keys) {
            TreeSet<String> part = new TreeSet<>();
            for (String nextPart : list) {
                if (strKey.equals(nextPart.substring(0, 2))) {
                    part.add(nextPart);
                }
            }
            correct.addAll(part);
        }
        String[] result = new String[correct.size()];
        return correct.toArray(result);
    }
}
