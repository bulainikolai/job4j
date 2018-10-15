package ru.job4j.search;

/**
 * Person
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 15.10.2018
 */
public class Person {
    /**
     * Contains name of person
     */
    private String name;
    /**
     * Contains surname of person
     */
    private String surname;
    /**
     * Contains phone of person
     */
    private String phone;
    /**
     * Contains address of person
     */
    private String address;

    /**
     * Constructor of object Person
     * @param name it is name of new Person
     * @param surname it is surname of new Person
     * @param phone it is phone of new Person
     * @param address it is address of new Person
     */
    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Method getName
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Method getSurname
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Method getPhone
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Method getAddress
     * @return address
     */
    public String getAddress() {
        return address;
    }
}
