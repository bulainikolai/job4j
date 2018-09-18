
package ru.job4j.chess.firuges.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookWhite implements Figure {
    private final Cell position;

    public RookWhite(final Cell position) {
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
        int changeX = dest.x - source.x;
        int changeY = dest.y - source.y;
        int point = 0;
        int size = Math.abs(changeX) > 0 ? Math.abs(changeX) : Math.abs(changeY);
        Cell[] steps = new Cell[size];
        Cell[] cells = Cell.values();
        for (int index = 0; index < cells.length; index++) {
            if ((deltaX > 0 && deltaY == 0) || (deltaX == 0 && deltaY > 0)) {
                if ((source.x + changeX == cells[index].x) && (source.y + changeY == cells[index].y)) {
                    steps[point] = cells[index];
                    changeX = changeX + deltaX;
                    changeY = changeY + deltaY;
                    point++;
                }
            }
            if ((deltaX < 0 && deltaY == 0) || (deltaX == 0 && deltaY < 0)) {
                if (dest.x - changeX - deltaX == cells[index].x && dest.y - changeY - deltaY == cells[index].y) {
                    steps[point] = cells[index];
                    changeX = changeX + deltaX;
                    changeY = changeY + deltaY;
                    point++;
                }
            }
            if (point == steps.length) {
                break;
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }

    private boolean isTarget(Cell source, Cell dest) {
        return (source.x == dest.x && source.y != dest.y) || (source.y == dest.y && source.x != dest.x);
    }
}
