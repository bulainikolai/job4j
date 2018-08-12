package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * FactorialTest.
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 12.08.2018
 */
public class FactorialTest {

    /**
     * Test calc.
     */
    @Test
    public void whenParamIsFiveThen120() {
        Factorial myFactorial = new Factorial();
        int result = myFactorial.calc(5);
        assertThat(result, is(120));
    }
}
