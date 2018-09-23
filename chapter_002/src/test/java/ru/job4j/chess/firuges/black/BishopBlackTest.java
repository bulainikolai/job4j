package ru.job4j.chess.firuges.black;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
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
        assertThat(steps, arrayContainingInAnyOrder(new Cell[] {Cell.D7, Cell.E6, Cell.F5, Cell.G4}));
    }

    /**
     * Test way() with distance from G4 to C8
     */
    @Test
    public void whenSoursG4AndTargetC8OnDiagonalThanArray() {
        Figure bishop = new BishopBlack(Cell.G4);
        Cell[] steps = bishop.way(bishop.position(), Cell.C8);
        assertThat(steps, arrayContainingInAnyOrder(new Cell[] {Cell.C8, Cell.D7, Cell.E6, Cell.F5}));
    }

    /**
     * Test way() with distance from C8 to A6
     */
    @Test
    public void whenSoursC8AndTargetA6OnDiagonalThanArray() {
        Figure bishop = new BishopBlack(Cell.C8);
        Cell[] steps = bishop.way(bishop.position(), Cell.A6);
        assertThat(steps, arrayContainingInAnyOrder(new Cell[] {Cell.B7, Cell.A6}));
    }

    /**
     * Test way() with distance from A6 to C8
     */
    @Test
    public void whenSoursA6AndTargetC8OnDiagonalThanArray() {
        Figure bishop = new BishopBlack(Cell.A6);
        Cell[] steps = bishop.way(bishop.position(), Cell.C8);
        assertThat(steps, arrayContainingInAnyOrder(new Cell[] {Cell.B7, Cell.C8}));
    }

    /**
     * Test way() with distance from C8 to C6
     *
     * get ImpossibleMoveException
     */
    @Test
    public void whenSoursC8AndTargetC6OnDiagonalThanException() {
        Figure bishop = new BishopBlack(Cell.C8);
        try {
            Cell[] steps = bishop.way(bishop.position(), Cell.C6);
        } catch(ImpossibleMoveException ime) {
            System.out.println(ime);
        }
        assertThat(this.mem.toString(), is(String.format("ru.job4j.chess.ImpossibleMoveException: Can't move by this way%n")));
    }

}
