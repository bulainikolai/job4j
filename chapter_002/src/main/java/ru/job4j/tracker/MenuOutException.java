package ru.job4j.tracker;

/**
 * MenuOutException
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 08.09.2018
 */
public class MenuOutException extends RuntimeException {

    /**
     * Constructor of user exception
     * @param msg
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
