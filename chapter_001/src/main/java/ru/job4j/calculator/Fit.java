package ru.job4j.calculator;

/**
 * Fit Программа расчета идеального веса.
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 */
public class Fit {

    /**
     * Contains the value subtracted from the man's height
     */
    private int man = 100;

    /**
     * CContains the value subtracted from the woman's height
     */
    private int woman = 110;

    /**
     * Contains the general multiplier
     */
    private double multiplier = 1.15;

    /**
     * Method manWeight Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - man) * multiplier;
    }

    /**
     * Method womanWeight Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - woman) * multiplier;
    }
}