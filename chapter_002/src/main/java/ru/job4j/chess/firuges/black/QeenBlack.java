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
public class QeenBlack implements Figure {
    private final Cell position;

    public QeenBlack(final Cell position) {
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
        int deltaX = Integer.compare(source.x, dest.x);
        int deltaY = Integer.compare(source.y, dest.y);
        int changeX = 0;
        int changeY = 0;
        int point = 0;
        int size = Math.abs(dest.x - source.x) > 0 ? Math.abs(dest.x - source.x) : Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[size];
        Cell[] cells = Cell.values();
        while (point < steps.length) {
            for (int index = 0; index < cells.length; index++) {
                if ((dest.x + changeX == cells[index].x) && (dest.y + changeY == cells[index].y)) {
                    steps[point] = cells[index];
                    changeX = changeX + deltaX;
                    changeY = changeY + deltaY;
                    point++;
                    break;
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenBlack(dest);
    }

    private boolean isTarget(Cell source, Cell dest) {
        return (source.x == dest.x && source.y != dest.y)
                || (source.y == dest.y && source.x != dest.x)
                || (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y));
    }
}
