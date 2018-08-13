package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Paint return graphic picture.
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 12.08.2018
 */
public class Paint {

    /**
     * Method rightTrl make triangle in string
     * @param height of triangle
     * @return right-side triangle
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Method leftTrl make triangle in string
     * @param height of triangle
     * @return left-side triangle
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }

    /**
     * Method pyramid make pyramid in string
     * @param height of pyramid
     * @return string, with view lake pyramid
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Method loopBy consist of general rules about new picture
     * @param height of new form
     * @param weight of new form
     * @param predict condition of putting a marker
     * @return string, with specific view
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
