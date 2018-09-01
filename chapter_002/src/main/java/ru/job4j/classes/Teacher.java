package ru.job4j.classes;

/**
 * Teacher
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 01.09.2018
 */
public class Teacher extends Profession {
    /**
     * Constructor of object Teacher
     */
    public Teacher(String name, String profession) {
        super(name, profession);
    }
    /**
     * Method teach, use for teaching students
     */
    public void teach(Student student) {
    }
}
