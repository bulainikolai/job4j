package ru.job4j.array;

/**
 * ArrayChar
 * Обертка над строкой.
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 14.08.2018
 */
public class ArrayChar {

    /**
     * Contains array of char elements fro string
     */
    private char[] data;

    /**
     * ArrayChar constructor
     * Converts this string to a new character array
     * @param line
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int index = 0; index < value.length; index++) {
            if (value[index] != this.data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
