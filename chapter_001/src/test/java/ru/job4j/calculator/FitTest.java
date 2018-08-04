package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Nikolai Bulai (mailto:turisto777.nb@gmail.com)
 * @version 1
 * @since 04.08.2018
 */
public class FitTest {

    /**
     * Test manWeight.
     */
    @Test
    public void whenManHeight180ThenManWeight92() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    /**
     * Test womanWeight.
     */
    @Test
    public void whenWomanHeight170ThenWomanWeight69() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}