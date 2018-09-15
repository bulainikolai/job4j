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
    public Cell[] way(Cell source, Cell dest) {
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        Cell[] steps = new Cell[Math.abs(deltaX)];
        Cell[] cells = Cell.values();
        int index = 0;
        if (deltaX > 0 && deltaY > 0) {
            for (Cell cell : cells) {
                if (source.x + index + 1 == cell.x && source.y + index + 1 == cell.y) {
                    steps[index] = cell;
                    index++;
                    if (index == Math.abs(deltaX)) {
                        break;
                    }
                }
            }
        }
        if (deltaX > 0 && deltaY < 0) {
            for (Cell cell : cells) {
                if (source.x + index + 1 == cell.x && source.y - index - 1 == cell.y) {
                    steps[index] = cell;
                    index++;
                    if (index == Math.abs(deltaX)) {
                        break;
                    }
                }
            }
        }
        if (deltaX < 0 && deltaY > 0) {
            for (int number = cells.length - 1; number >= 0; number--) {
                if (source.x - index - 1 == cells[number].x && source.y + index + 1 == cells[number].y) {
                    steps[index] = cells[number];
                    index++;
                    if (index == Math.abs(deltaX)) {
                        break;
                    }
                }
            }
        }
        if (deltaX < 0 && deltaY < 0) {
            for (int number = cells.length - 1; number >= 0; number--) {
                if (source.x - index - 1 == cells[number].x && source.y - index - 1 == cells[number].y) {
                    steps[index] = cells[number];
                    index++;
                    if (index == Math.abs(deltaX)) {
                        break;
                    }
                }
            }
        }
        if (!this.isDiagonal(source, dest)) {
            throw new ImpossibleMoveException("Can't move by this way");
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
        boolean result = false;
        int deltaX = dest.x - source.x;
        int deltaY = dest.y - source.y;
        if (Math.abs(deltaX) == Math.abs(deltaY)) {
            result = true;
        }
        return result;
    }
}
