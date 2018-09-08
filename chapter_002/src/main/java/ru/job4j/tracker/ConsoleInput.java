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

    /**
     * Method ask get point of menu
     * @param question about select
     * @param range count of available points of menu
     * @return point of menu
     */
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value: range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
