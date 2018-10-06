package ru.job4j.addtask;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CoffeMachineTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 05.10.2018
 */
public class CoffeMachineTest {

    /**
     * Test of changes
     */
    @Test
    public void whenValue50Prise35ThanCoins10And5() {
        CoffeMachine coffeMachine = new CoffeMachine();
        int[] result = coffeMachine.changes(50, 35);
        assertThat(result, is(new int[] {10, 5}));
    }

    /**
     * Test of changes
     */
    @Test
    public void whenValue100Prise57ThanCoinsFour10And2And1() {
        CoffeMachine coffeMachine = new CoffeMachine();
        int[] result = coffeMachine.changes(100, 57);
        assertThat(result, is(new int[] {10, 10, 10, 10, 2, 1}));
    }

    /**
     * Test of changes
     */
    @Test
    public void whenValue10Prise1ThanCoins5And2And2() {
        CoffeMachine coffeMachine = new CoffeMachine();
        int[] result = coffeMachine.changes(10, 1);
        assertThat(result, is(new int[] {5, 2, 2}));
    }
}
