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
}
