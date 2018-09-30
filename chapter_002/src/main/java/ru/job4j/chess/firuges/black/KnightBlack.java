package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KnightBlack implements Figure {
    private final Cell position;

    public KnightBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isTarget(source, dest)) {
            throw new ImpossibleMoveException("Can't move by this way");
        }
        return new Cell[] {dest};
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightBlack(dest);
    }

    private boolean isTarget(Cell source, Cell dest) {
        return (Math.abs(dest.x - source.x) == 1 && Math.abs(dest.y - source.y) == 2)
                || (Math.abs(dest.x - source.x) == 2 && Math.abs(dest.y - source.y) == 1);
    }
}

