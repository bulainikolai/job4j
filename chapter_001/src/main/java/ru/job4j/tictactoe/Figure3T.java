package ru.job4j.tictactoe;

import javafx.scene.shape.Rectangle;

/**
 * Figure3T create a Rectangle
 * extends from class Rectangle
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 17.08.2018
 */

public class Figure3T extends Rectangle {

    /**
     *
     */
    private boolean markX = false;
    private boolean markO = false;

    /**
     * Constructor
     */
    public Figure3T() {
    }

    /**
     * Constructor
     * @param markX boolean
     */
    public Figure3T(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     * Method take setter of object's attribute
     * @param markX boolean
     */
    public void take(boolean markX) {
        this.markX = markX;
        this.markO = !markX;
    }

    /**
     * Method hasMarkX is getter
     * @return value markX
     */
    public boolean hasMarkX() {
        return this.markX;
    }

    /**
     * Method hasMarkO is getter
     * @return value hasMarkO
     */
    public boolean hasMarkO() {
        return this.markO;
    }
}
