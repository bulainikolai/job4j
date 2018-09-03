package ru.job4j.tracker;

import java.util.*;

/**
 * ConsoleInput
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 03.09.2018
 */
public class ConsoleInput implements Input {

    /**
     * Contains object of Scanner
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Method ask get information from user
     * @param question important information
     * @return answer on question
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
