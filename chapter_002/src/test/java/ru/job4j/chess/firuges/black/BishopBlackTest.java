package ru.job4j.chess.firuges.black;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * BishopBlackTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 23.09.2018
 */
public class BishopBlackTest {

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
     * Test way() with distance from C8 to G4
     */
    @Test
    public void whenSoursC8AndTargetG4OnDiagonalThanArray() {
        Figure bishop = new BishopBlack(Cell.C8);
        Cell[] steps = bishop.way(bishop.position(), Cell.G4);
        assertThat(steps, is(new Cell[] {Cell.G4, Cell.F5, Cell.E6, Cell.D7}));
    }

    /**
     * Test way() with distance from G4 to C8
     */
    @Test
    public void whenSoursG4AndTargetC8OnDiagonalThanArray() {
        Figure bishop = new BishopBlack(Cell.G4);
        Cell[] steps = bishop.way(bishop.position(), Cell.C8);
        assertThat(steps, is(new Cell[] {Cell.C8, Cell.D7, Cell.E6, Cell.F5}));
    }

    /**
     * Test way() with distance from C8 to A6
     */
    @Test
    public void whenSoursC8AndTargetA6OnDiagonalThanArray() {
        Figure bishop = new BishopBlack(Cell.C8);
        Cell[] steps = bishop.way(bishop.position(), Cell.A6);
        assertThat(steps, is(new Cell[] {Cell.A6, Cell.B7}));
    }

    /**
     * Test way() with distance from A6 to C8
     */
    @Test
    public void whenSoursA6AndTargetC8OnDiagonalThanArray() {
        Figure bishop = new BishopBlack(Cell.A6);
        Cell[] steps = bishop.way(bishop.position(), Cell.C8);
        assertThat(steps, is(new Cell[] {Cell.C8, Cell.B7}));
    }

    /**
     * Test way() with distance from C8 to C6
     *
     * get ImpossibleMoveException
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenSoursC8AndTargetC6OnDiagonalThanException() {
        Figure bishop = new BishopBlack(Cell.C8);
        bishop.way(bishop.position(), Cell.C6);
    }

}
