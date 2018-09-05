package ru.job4j.pseudo;

/**
 * Paint
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 05.09.2018
 */
public class Paint {

    /**
     * Method draw print a figure
     * @param shape one of figure
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
