package ru.job4j.tracker;

/**
 * BaseAction abstract
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 10.09.2018
 */
public abstract class BaseAction implements UserAction {
    /**
     * Contains point's number of menu
     */
    private final int pointMenu;
    /**
     * Contains point's message of menu
     */
    private final String message;

    /**
     * Constructor
     * @param pointMenu
     * @param message
     */
    protected BaseAction(final int pointMenu, final String message) {
        this.pointMenu = pointMenu;
        this.message = message;
    }

    /**
     * Method key give point of menu
     * @return point of menu
     */
    @Override
    public int key() {
        return this.pointMenu;
    }

    /**
     * Method info show info about current point of menu
     * @return info about point
     */
    @Override
    public String info() {
        return String.format("%s. %s.", this.key(), this.message);
    }
}
