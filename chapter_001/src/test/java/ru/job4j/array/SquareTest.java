package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SquareTest.
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 2
 * @since 14.08.2018
 */
public class SquareTest {

    /**
     * Test calculate with param 3.
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }

    /**
     * Test calculate with param 5.
     */
    @Test
    public void whenBound7Then1And4And9And16And25() {
        int bound = 5;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25};
        assertThat(rst, is(expect));
    }

    /**
     * Test calculate with param 7
     */
    @Test
    public void whenBound7Then1And4And9And16And25And36And49() {
        int bound = 7;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25, 36, 49};
        assertThat(rst, is(expect));
    }

}
