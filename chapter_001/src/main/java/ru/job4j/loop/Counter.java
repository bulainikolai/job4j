package ru.job4j.loop;

/**
 * Counter return sum of even numbers.
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 12.08.2018
 */
public class Counter {

    /**
     * Method add
     * @param start First number.
     * @param finish Last number.
     * @return sum of even numbers from start to finish
     */
    public int add(int start, int finish) {
        int evenNumber = (start % 2 != 0) ? start + 1 : start;
        for (int i = evenNumber + 2; i <= finish; i += 2) {
            evenNumber += i;
        }
        return evenNumber;
    }
}
