package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PriorityQueueTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 15.10.2018
 */
public class PriorityQueueTest {
    /**
     * Test of put
     */
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    /**
     * Test of put
     */
    @Test
    public void whenHigherPriorityThenAAA() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("5", 5));
        queue.put(new Task("3", 3));
        queue.put(new Task("7", 7));
        queue.put(new Task("6", 6));
        queue.put(new Task("2", 2));
        queue.put(new Task("AAA", 1));
        Task result = queue.take();
        assertThat(result.getDesc(), is("AAA"));
    }
}
