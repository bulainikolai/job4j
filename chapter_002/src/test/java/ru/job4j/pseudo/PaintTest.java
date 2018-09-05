package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
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
     * Contains object of defaulted stream
     */
    private final PrintStream stdout = System.out;

    /**
     * Contains object of buffer
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    /**
     * Method loadOutput change from standard stream to buffer
     */
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Method backOutput change from buffer to standard stream
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }
    /**
     * Test for draw(Square)
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(this.out.toByteArray()),
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
    }

    /**
     * Test for draw(Triangle)
     */
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringJoiner(
                                ""
                                )
                                .add("  +  ")
                                .add(" +  + ")
                                .add("+++++")
                                .add(System.lineSeparator())
                                .toString()
                )
        );
    }
}
