package ru.job4j.tracker;

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
}
