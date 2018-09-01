package ru.job4j.tictactoe;

import java.util.function.Predicate;

/**
 * Logic3T
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 17.08.2018
 */
public class Logic3T {

    /**
     * Contain array with empty cells
     */
    private final Figure3T[][] table;

    /**
     * Constructor
     * @param table
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Method fillBy
     * @param predicate
     * @param startX coordinate X of start dot
     * @param startY coordinate Y of start dot
     * @param deltaX step of movement along the x-axis
     * @param deltaY step of movement along the y-axis
     * @return true if model with 3 cells true
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Method isWinnerX
     * @return boolean is X won
     */
    public boolean isWinnerX() {
        boolean result = false;
        for (int index = 0; index < this.table.length; index++) {
            if (
                    this.fillBy(Figure3T::hasMarkX, 0, index, 1, 0)
                    || this.fillBy(Figure3T::hasMarkX, index, 0, 0, 1)
            ) {
                result = true;
                break;
            }
        }
        return result
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1);
    }

    /**
     * Method isWinnerO
     * @return boolean is O won
     */
    public boolean isWinnerO() {
        boolean result = false;
        for (int index = 0; index < this.table.length; index++) {
            if (
                    this.fillBy(Figure3T::hasMarkO, 0, index, 1, 0)
                    || this.fillBy(Figure3T::hasMarkO, index, 0, 0, 1)
            ) {
                result = true;
                break;
            }
        }
        return result
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    /**
     * Method hasGap checks for empty cells
     * @return true if anyone cell empty
     */
    public boolean hasGap() {
        for (int out = 0; out < this.table.length; out++) {
            for (int in = 0; in < this.table.length; in++) {
                if (!this.table[out][in].hasMarkX() && !this.table[out][in].hasMarkO()) {
                    return true;
                }
            }
        }
        return false;
    }
}
