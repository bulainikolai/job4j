package ru.job4j.tracker;

import java.util.List;

/**
 * ValidateInput
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 08.09.2018
 */
public class ValidateInput implements Input {

    /**
     * Contains object of class, which implemented  Input
     */
    private final Input input;

    /**
     * Constructor
     * @param input
     */
    public ValidateInput(final Input input) {
        this.input = input;
    }

    /**
     * Method ask use Method ask of added object
     * @param question
     * @return answer in string
     */
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    /**
     * Method ask use Method ask of added object
     * @param question about select
     * @param range count of available points of menu
     * @return answer in integer
     */
    @Override
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int answer = -1;
        do {
            try {
                answer = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select point from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        } while (invalid);
            return answer;
    }
}
