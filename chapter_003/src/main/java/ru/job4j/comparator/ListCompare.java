package ru.job4j.comparator;

import java.util.Comparator;

/**
 * ListCompare
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 19.10.2018
 */
public class ListCompare implements Comparator<String> {

    /**
     * Compare strings lexicographically
     * @param left string
     * @param right string
     * @return 0 if equal, positive if left bigger right, else negative
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int count = left.length() <= right.length() ? left.length() : right.length();
        for (int index = 0; index < count; index++) {
            char chLeft = left.charAt(index);
            char chRight = right.charAt(index);
            int rsl = Character.compare(chLeft, chRight);
            if (rsl != 0) {
                result = rsl;
                break;
            }
            if (left.length() - (index + 1) == 0 || right.length() - (index + 1) == 0) {
                result = Integer.compare(left.length(), right.length());
                break;
            }
        }
        return result;
    }
}
