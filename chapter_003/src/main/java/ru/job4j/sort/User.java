package ru.job4j.sort;

/**
 * User
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 18.10.2018
 */
public class User implements Comparable<User> {
    /**
     * Contain name of User
     */
    private String name;
    /**
     * Contzin age of user
     */
    private Integer age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Get age
     * @return age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Compare 2 objects of User by age
     * @param user other object
     * @return if equal than 0, if this bigger than 1, else -1
     */
    @Override
    public int compareTo(User user) {
        return this.age.compareTo(user.age);
    }
}
