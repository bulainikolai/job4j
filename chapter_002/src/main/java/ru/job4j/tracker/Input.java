package ru.job4j.tracker;

import java.util.*;

/**
 * Input
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 03.09.2018
 */
public interface Input {

    /**
     * Method ask for connect to user by console
     * @param question
     * @return answer
     */
    String ask(String question);

    /**
     * Method ask get point of menu
     * @param question about select
     * @param range count of available points of menu
     * @return point of menu
     */
    int ask(String question, List<Integer> range);
}
