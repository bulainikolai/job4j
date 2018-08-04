package ru.job4j.converter;

/**
 * Converter конвертер валюты
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 */
public class Converter {

    /**
     * Contains the number of rubles per dollar
     */
    private int rubleForDollar = 60;

    /**
     * Contains the number of rubles per euro
     */
    private int rubleForEuro = 70;

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / this.rubleForEuro;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return value / this.rubleForDollar;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли
     */
    public int euroToRuble(int value) {
        return value * this.rubleForEuro;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли
     */
    public int dollarToRuble(int value) {
        return value * this.rubleForDollar;
    }
}
