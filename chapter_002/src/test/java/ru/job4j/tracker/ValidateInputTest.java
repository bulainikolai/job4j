package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * ValidateInputTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 08.09.2018
 */
public class ValidateInputTest {
    /**
     * Contains object of buffer
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    /**
     * Contains object of defaulted stream
     */
    private final PrintStream out = System.out;

    /**
     *  Method loadMem change from standard stream to buffer
     */
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    /**
     * Method backOutput change from buffer to standard stream
     */
    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Test for ask()
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("Enter", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("%nPlease enter validate data again.%n%n")
                )
        );
    }

    /**
     * Test for ask()
     */
    @Test
    public void whenNotFromRangeInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"5", "1"})
        );
        List<Integer> range = new ArrayList<>();
        range.add(1);
        input.ask("Enter", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("%nPlease select point from menu.%n%n")
                )
        );
    }
}
