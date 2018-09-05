package ru.job4j.pseudo;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PaintTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 05.09.2018
 */
public class PaintTest {

    /**
     * Test for draw(Square)
     */
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+     +")
                                .append("+     +")
                                .append("++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);
    }

    /**
     * Test for draw(Triangle)
     */
    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("  +  ")
                                .append(" +  + ")
                                .append("+++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);
    }
}
