package ru.job4j.classes;

/**
 * Doctor
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 01.09.2018
 */
public class Doctor extends Profession {
    /**
     * Constructor
     * @param name
     * @param profession
     */
    public Doctor(String name, String profession) {
        super(name, profession);
    }

    /**
     * Method heal, healing an Patient
     * @param patient
     * @return diagnose object
     */
    public Diagnose heal(Patient patient) {
        return new Diagnose();
    }
}
