package ru.job4j.bank;

import org.junit.Test;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * BankTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 20.11.2018
 */
public class BankTest {
    /**
     * Test of addUser
     */
    @Test
    public void whenAddNewUserThenCanGetIt() {
        Bank bank = new Bank();
        User user = new User("Jack", "111");
        bank.addUser(user);
        Map<User, List<Account>> result =  bank.getMap();
        boolean rst = result.containsKey(user);
        assertThat(rst, is(true));
    }

    /**
     * Test of deleteUser
     */
    @Test
    public void whenAdd2AndDelete1ThenHave1() {
        Bank bank = new Bank();
        User user1 = new User("Jack", "111");
        User user2 = new User("Mike", "222");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.deleteUser(user1);
        Map<User, List<Account>> result =  bank.getMap();
        boolean rst = result.containsKey(user1);
        assertThat(rst, is(false));
    }

    /**
     * Test of addAccountToUser
     */
    @Test
    public void whenAddAccountThenUserHasAccounts() {
        Bank bank = new Bank();
        User user = new User("Jack", "111");
        bank.addUser(user);
        bank.addAccountToUser("111", new Account(1000.0, "AAA"));
        Map<User, List<Account>> result =  bank.getMap();
        List<Account> account = result.get(user);
        assertThat(account.get(0).getRequisites(), is(String.format("%s", "AAA")));
    }

    /**
     * Test of deleteAccountFromUser
     */
    @Test
    public void whenAdd3AccountsAndDelete1ThenUserHas2Account() {
        Bank bank = new Bank();
        User user = new User("Jack", "111");
        bank.addUser(user);
        bank.addAccountToUser("111", new Account(1000.0, "AAA"));
        bank.addAccountToUser("111", new Account(2000.0, "BBB"));
        Account account = new Account(3000.0, "CCC");
        bank.addAccountToUser("111", account);
        bank.deleteAccountFromUser("111", account);
        Map<User, List<Account>> result =  bank.getMap();
        List<Account> accounts = result.get(user);
        assertThat(
                new String[] {accounts.get(0).getRequisites(), accounts.get(1).getRequisites()},
                is(new String[] {"AAA", "BBB"})
        );
    }

    /**
     * Test of getUserAccounts
     */
    @Test
    public void whenAddAccountThenGetAccount() {
        Bank bank = new Bank();
        User user = new User("Jack", "111");
        bank.addUser(user);
        bank.addAccountToUser("111", new Account(1.0, "AAA"));
        bank.addAccountToUser("111", new Account(2.0, "BBB"));
        List<Account> result = bank.getUserAccounts("111");
        assertThat(
                new String[] {result.get(0).getRequisites(), result.get(1).getRequisites()},
                is(new String[] {"AAA", "BBB"})
        );
    }

    /**
     * Test of transferMoney
     */
    @Test
    public void whenTransferFrom1AccountThenSecondHaveMoreMoney() {
        Bank bank = new Bank();
        User user = new User("Jack", "111");
        User user2 = new User("Bill", "222");

        bank.addUser(user);
        bank.addUser(user2);
        bank.addAccountToUser("111", new Account(100.0, "AAA"));
        bank.addAccountToUser("222", new Account(100.0, "BBB"));

        boolean result = bank.transferMoney("111", "AAA", "222", "BBB", 50.0);
        assertThat(result, is(true));
    }
}
