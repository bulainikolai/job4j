package ru.job4j.pseudo;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * SquareTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 05.09.2018
 */
public class SquareTest {

    /**
     * Test for draw
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+     +")
                                .append("+     +")
                                .append("++++")
                                .toString()
                )
        );
    }
}
