package ru.job4j.pseudo;

/**
 * Triangle
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 05.09.2018
 */
public class Triangle implements Shape {

    /**
     * Method draw made a triangle
     * @return triangle in string
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  +  ");
        pic.append(" +  + ");
        pic.append("+++++");
        return pic.toString();
    }
}
