package ru.job4j.bank;

/**
 * User
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 20.11.2018
 */
public class User implements Comparable<User> {
    /**
     * Name of user
     */
    private String name;
    /**
     * Passport of user
     */
    private String passport;

    /**
     * Constructor
     * @param name String
     * @param passport String
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Overrided method equals
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }

    /**
     * Overrided method hashCode
     * @return int
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }

    /**
     * Overrided method compareTo
     * @param user User's object
     * @return int
     */
    @Override
    public int compareTo(User user) {
        int res = this.getName().compareToIgnoreCase(user.getName());
        return res != 0 ? res : this.getPassport().compareTo(user.getPassport());
    }

    /**
     * Get field name
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get field passport
     * @return String
     */
    public String getPassport() {
        return this.passport;
    }
}
