package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TurnTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 2
 * @since 14.08.2018
 */
public class TurnTest {

    /**
     * Test turn with param array with even element
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turner.turn(input);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));

    }

    /**
     * Test turn with param array with odd element
     */
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {2, 4, 6, 59, 99};
        int[] result = turner.turn(input);
        int[] expect = new int[] {99, 59, 6, 4, 2};
        assertThat(result, is(expect));
    }
}
