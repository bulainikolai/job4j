package ru.job4j.bank;

/**
 * Account
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 20.11.2018
 */
public class Account {
    /**
     * Money on account
     */
    private double value;
    /**
     * Code of account
     */
    private String requisites;

    /**
     * Constructor
     * @param value double
     * @param requisites String
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Get field value
     * @return string value
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Set field value
     * @param money how much we transfer
     */
    public void setValue(double money) {
        this.value = money;
    }

    /**
     * Get field Requisites
     * @return string requisites
     */
    public String getRequisites() {
        return this.requisites;
    }

    /**
     * Overrided method. Don't use field value
     * @param o other object of Account
     * @return 0, 1, -1
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }

    /**
     * Overrided method hashCode
     * @return int hashCode
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (requisites != null ? requisites.hashCode() : 0);
        return result;
    }
}
