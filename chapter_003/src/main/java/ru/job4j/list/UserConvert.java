package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * UserConvert
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 17.10.2018
 */
public class UserConvert {

    /**
     * Convert list to HashMap
     * @param list list of User's objects
     * @return HashMap of User's objects
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
