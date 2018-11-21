package ru.job4j.bank;

import java.util.*;

/**
 * Bank
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 20.11.2018
 */
public class Bank {
    private Map<User, List<Account>> data = new TreeMap<>();

    /**
     * добавление пользователя
     * @param user
     */
    public void addUser(User user) {
        this.data.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * удаление пользователя
     * @param user
     */
    public void deleteUser(User user) {
        this.data.remove(user);
    }

    /**
     * добавить счёт пользователю
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        User user = this.getUserByPassport(passport);
        if (user != null) {
            this.data.get(user).add(account);
        }
    }

    /**
     * удалить один счёт пользователя
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = this.getUserByPassport(passport);
        if (user != null) {
            this.data.get(user).remove(account);
        }
    }

    /**
     * получить список счетов для пользователя
     * @param passport
     * @return
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> listAccounts = null;
        User user = this.getUserByPassport(passport);
        if (user != null) {
            listAccounts = this.data.get(user);
        }
        return listAccounts;
    }

    /**
     * метод для перечисления денег с одного счёта на другой счёт:
     * если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят)
     *  должен вернуть false.
     * @param srcPassport number of sender's passport
     * @param srcRequisite number of sender's account number
     * @param destPassport number of receiver's passport
     * @param dstRequisite number of receiver's account number
     * @param amount money
     * @return boolean
     */
    public boolean transferMoney(
            String srcPassport,
            String srcRequisite,
            String destPassport,
            String dstRequisite,
            double amount) {

        boolean result = false;
        Account sourceAccount = this.getAccountByRequisiteFromUserPassport(srcPassport, srcRequisite);
        Account destAccount = this.getAccountByRequisiteFromUserPassport(destPassport, dstRequisite);
        if (
                sourceAccount != null
                && destAccount != null
                && sourceAccount.getValue() > amount
            ) {
            sourceAccount.setValue(sourceAccount.getValue() - amount);
            destAccount.setValue(destAccount.getValue() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Find user by passport
     * @param passport String
     * @return User
     */
    public User getUserByPassport(String passport) {
        Set<User> allUsers = this.data.keySet();
        User targetUser = null;
        for (User user : allUsers) {
            if (passport.equals(user.getPassport())) {
                targetUser = user;
            }
        }
        return targetUser;
    }

    /**
     * Find Account by passport and requisite
     * @param passport String
     * @param requisite requisite
     * @return Account
     */
    public Account getAccountByRequisiteFromUserPassport(String passport, String requisite) {
        Account target = null;
        User user = this.getUserByPassport(passport);
        if (user != null) {
            List<Account> accounts = this.data.get(user);
            int index = accounts.indexOf(new Account(0, requisite));
            if (index != -1) {
                target = accounts.get(index);
            }
        }
        return target;
    }

    /**
     * Get field data
     * @return Map
     */
    public Map<User, List<Account>> getMap() {
        return data;
    }
}
