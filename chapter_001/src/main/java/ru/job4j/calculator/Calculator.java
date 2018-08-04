package ru.job4j.calculator;

/**
 * Calculator арифметические расчеты
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 */
public class Calculator {

    /**
     * Contains Result of calculation
     */
    private double result;

    /**
     * Method add
     * @param first
     * @param second
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract
     * @param first
     * @param second
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div
     * @param first
     * @param second
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple
     * @param first
     * @param second
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult
     * @return Result of calculation
     */
    public double getResult() {
        return this.result;
    }
}