package ru.job4j.sort;

import java.util.*;

/**
 * SortUser
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 18.10.2018
 */
public class SortUser {
    /**
     * Sort List of User's objects by age
     * @param list of User's objects
     * @return sorted Set of User's objects
     */
    public Set<User> sort(List<User> list) {
        Set<User> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }

    /**
     * Sort list by length of name
     * @param list unsorted list
     * @return sorted list
     */
    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return Integer.compare(user.getName().length(), t1.getName().length());
            }
        });
        return list;
    }

    /**
     * Sort list by name lexicographically, then by age
     * @param list unsorted list
     * @return sorted list
     */
    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                int res = user.getName().compareToIgnoreCase(t1.getName());
                return res != 0 ? res : Integer.compare(user.getAge(), t1.getAge());
            }
        });
        return list;
    }
}
