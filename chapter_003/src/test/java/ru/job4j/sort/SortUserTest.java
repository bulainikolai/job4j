package ru.job4j.sort;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SortUserTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 18.10.2018
 */
public class SortUserTest {
    /**
     * Test of sort
     */
    @Test
    public void whenGetUnsortedListThanSortedTreeSet() {
        List<User> users = new ArrayList<>();
        users.addAll(
                Arrays.asList(
                    new User("Gilbert", 30),
                    new User("Abraham", 20),
                    new User("Bred", 40),
                    new User("Fred", 10)
                )
        );
        Set<User> result = new SortUser().sort(users);
        int[] check = new int[4];
        int index = 0;
        for (User user : result) {
            check[index] = user.getAge();
            index++;
        }
        assertThat(check, is(new int[] {10, 20, 30, 40}));
    }

    /**
     * Test of sortNameLength
     */
    @Test
    public void whenGetUnsortedListThanSortedListByLengthOfName() {
        List<User> users = new ArrayList<>();
        users.addAll(
                Arrays.asList(
                        new User("Kyle", 30),
                        new User("David", 20),
                        new User("Abraham", 40),
                        new User("Max", 10)
                )
        );
        List<User> result = new SortUser().sortNameLength(users);
        String[] check = new String[] {
                result.get(0).getName(),
                result.get(1).getName(),
                result.get(2).getName(),
                result.get(3).getName(),
        };
        assertThat(check, is(new String[] {"Max", "Kyle", "David", "Abraham"}));
    }

    /**
     * Test of sortByAllFields
     */
    @Test
    public void whenGetUnsortedListThanSortedListByAllFields() {
        List<User> users = new ArrayList<>();
        users.addAll(
                Arrays.asList(
                        new User("Abraham", 30),
                        new User("David", 20),
                        new User("Abraham", 40),
                        new User("David", 10)
                )
        );
        List<User> result = new SortUser().sortByAllFields(users);
        String[] check = new String[] {
                result.get(0).getName(), String.valueOf(result.get(0).getAge()),
                result.get(1).getName(), String.valueOf(result.get(1).getAge()),
                result.get(2).getName(), String.valueOf(result.get(2).getAge()),
                result.get(3).getName(), String.valueOf(result.get(3).getAge()),
        };
        assertThat(check,
                is(new String[] {
                        "Abraham", String.valueOf(30),
                        "Abraham", String.valueOf(40),
                        "David", String.valueOf(10),
                        "David", String.valueOf(20),
                })
        );
    }
}
