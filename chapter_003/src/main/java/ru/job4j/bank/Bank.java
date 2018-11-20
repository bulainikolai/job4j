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
        Set<Map.Entry<User, List<Account>>> users = this.data.entrySet();
        for (Map.Entry<User, List<Account>> user : users) {
            if (passport.equals(user.getKey().getPassport())) {
                user.getValue().add(account);
            }
        }
    }

    /**
     * удалить один счёт пользователя
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        Set<Map.Entry<User, List<Account>>> users = this.data.entrySet();
        for (Map.Entry<User, List<Account>> user : users) {
            if (passport.equals(user.getKey().getPassport())) {
                user.getValue().remove(account);
            }
        }
    }

    /**
     * получить список счетов для пользователя
     * @param passport
     * @return
     */
    public List<Account> getUserAccounts(String passport) {
        Set<Map.Entry<User, List<Account>>> users = this.data.entrySet();
        List<Account> result = new ArrayList<>();
        for (Map.Entry<User, List<Account>> user : users) {
            if (passport.equals(user.getKey().getPassport())) {
                result = user.getValue();
            }
        }
        return result;
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
        List<Account> sourceAccount = getUserAccounts(srcPassport);
        List<Account> destAccount = getUserAccounts(destPassport);
        if (!sourceAccount.isEmpty() && !destAccount.isEmpty()) {
            int indexSource = sourceAccount.indexOf(new Account(0, srcRequisite));
            int indexDest = destAccount.indexOf(new Account(0, dstRequisite));
            if (indexSource != -1 && indexDest != -1) {
                Account sAccount = sourceAccount.get(indexSource);
                Account dAccount = destAccount.get(indexDest);
                if (sAccount.getValue() > amount) {
                    dAccount.setValue(dAccount.getValue() + amount);
                    sAccount.setValue(sAccount.getValue() - amount);
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * Get field data
     * @return Map
     */
    public Map<User, List<Account>> getMap() {
        return data;
    }
}
