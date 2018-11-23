package ru.job4j.functions;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * DiapasonTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 23.11.2018
 */
public class DiapasonTest {
    /**
     * Test of linearFunction
     */
    @Test
    public void whenUseLinearFunction() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.linearFunction(1, 3);
        assertThat(result, is(Arrays.asList(5D, 7D, 9D)));
    }

    /**
     * Test of quadraticFunction
     */
    @Test
    public void whenUseQuadraticFunction() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.quadraticFunction(1, 3);
        assertThat(result, is(Arrays.asList(0D, 9D, 22D)));
    }

    /**
     * Test of logarithmicFunction
     */
    @Test
    public void whenUseLogarithmicFunction() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.logarithmicFunction(1, 3);
        assertThat(result, is(Arrays.asList(0D, 0.7, 1.1)));
    }
}
