package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;

/**
 * UserConvertTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 17.10.2018
 */
public class UserConvertTest {

    /**
     * Test of process
     */
    @Test
    public void whenGetListThanHashMap() {
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "Ivan", "London");
        User user2 = new User(2, "Max", "Moscow");
        User user3 = new User(3, "Jack", "Paris");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        HashMap<Integer, User> result = new UserConvert().process(users);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, user1);
        expect.put(2, user2);
        expect.put(3, user3);
        assertThat(result, is(expect));
    }
}
