package ru.job4j.classes;

/**
 * Profession
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 01.09.2018
 */
public class Profession {
    /**
     * Contains name of a man
     */
    private String name;

    /**
     * Contains name of profession
     */
    private String profession;

    /**
     * Constructor of object
     * @param name name of a man
     * @param profession name of profession
     */
    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    /**
     * Method getName
     * @return field name
     */
    public String getName() {
        return this.name;
    }
}
