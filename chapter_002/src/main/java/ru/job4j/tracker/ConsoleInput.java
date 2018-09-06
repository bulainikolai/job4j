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
     * Contains first object of Scanner
     */
    private Scanner scannerFirst = new Scanner(System.in);

    /**
     * Contains second object of Scanner
     */
    private Scanner scannerSecond = new Scanner(System.in);

    /**
     * Method ask get information from user
     * @param question important information
     * @return answer on question
     */
    public String ask(String question) {
        System.out.print(question);
        return scannerFirst.nextLine();
    }

    /**
     * Method ask get point of menu
     * @param question about select
     * @param range count of available points of menu
     * @return point of menu
     */
    public int ask(String question, List<Integer> range) {
        int result;
        do {
            System.out.print(question);
            result = scannerSecond.nextInt();
        } while (result > (range.size() - 1));
        return result;
    }
}
