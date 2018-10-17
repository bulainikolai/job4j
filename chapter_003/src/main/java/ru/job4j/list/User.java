package ru.job4j.list;

/**
 * User
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 17.10.2018
 */
public class User {
    /**
     * Contain id
     */
    private int id;
    /**
     * Contain name
     */
    private String name;
    /**
     * Contain city
     */
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Give id
     * @return id
     */
    public int getId() {
        return this.id;
    }
}
