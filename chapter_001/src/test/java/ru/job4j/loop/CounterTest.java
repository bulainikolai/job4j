package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest.
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 12.08.2018
 */
public class CounterTest {

    /**
     * Test add.
     */
    @Test
    public void whenFromOneToTenThenThirty() {
        Counter sumNumbers = new Counter();
        int result = sumNumbers.add(1, 10);
        assertThat(result, is(30));
    }
}
