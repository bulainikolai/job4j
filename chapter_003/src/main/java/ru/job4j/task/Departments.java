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
        list.sort(new Comparator<String>() {
                    @Override
                    public int compare(String s, String t1) {
                        int result = 0;
                        String[] arrS = s.split("/");
                        String[] arrT1 = t1.split("/");
                        int count = arrS.length <= arrT1.length ? arrS.length : arrT1.length;
                        int firstPart = arrT1[0].compareTo(arrS[0]);
                        if (firstPart != 0) {
                            result = firstPart;
                        }
                        if (result == 0) {
                            for (int index = 1; index < count; index++) {
                                int otherPart = arrS[index].compareTo(arrT1[index]);
                                if (otherPart != 0) {
                                    result = otherPart;
                                    break;
                                }
                                if (arrS.length - (index + 1) == 0 || arrT1.length - (index + 1) == 0) {
                                    result = Integer.compare(arrS.length, arrT1.length);
                                    break;
                                }
                            }
                        }
                        return result;
                    }
        });
        String[] result = new String[list.size()];
        return list.toArray(result);
    }
}
