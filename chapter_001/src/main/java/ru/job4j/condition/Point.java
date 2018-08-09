package ru.job4j.condition;

/**
 * Point Программа расчета расстояния между точками.
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 */
public class Point {
    /**
     * Contains X coordinate.
     */
    private int x;

    /**
     * Contains Y coordinate.
     */
    private int y;

    /**
     * Сonstructor create object of class Point
     * @param x First coordinate
     * @param y Second coordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method distanceTo
     * @param that object of class Point
     * @return distance between two dots
     */
    public double distanceTo(Point that) {
        Point a = this;
        Point b = that;
        int x1 = a.x;
        int y1 = a.y;
        int x2 = b.x;
        int y2 = b.y;
        return Math.sqrt(
                Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
        );
    }
}
