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
public class BishopBlack implements Figure {
    /**
     * Содержит указатель на текущую позицию
     */
    private final Cell position;

    /**
     * Задание позиции при создании
     * @param position
     */
    public BishopBlack(final Cell position) {
        this.position = position;
    }

    /**
     * Вернет текущую позицию фигуры
     * @return текущая позиция фигуры
     */
    @Override
    public Cell position() {
        return this.position;
    }

    /**
     * Метод вернет массив шогов
     * @param source
     * @param dest
     * @return
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!this.isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Can't move by this way");
        }
        int deltaX = Integer.compare(source.x, dest.x);
        int deltaY = Integer.compare(source.y, dest.y);
        int changeX = 0;
        int changeY = 0;
        int point = 0;
        Cell[] steps = new Cell[Math.abs(dest.x - source.x)];
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

    /**
     * Создает новую фигуру для замены старой на новой позиции
     * @param dest новая позиция
     * @return фигура на новой позиции
     */
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    /**
     * Проверка, ходит ли фигура по диагонали
     * @param source начальноя положение фигуры
     * @param dest целевое положение фигуры
     * @return истину, если начальное положение и целевое положеие находятся на диагонали
     */
    private boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y);
    }
}
