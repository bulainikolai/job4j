package ru.job4j.chess.firuges.black;

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
        if (this.isDiagonal(source, dest)) {
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

    private boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        if (source.y < dest.y && source.x < dest.x) {
            int changeY = dest.y - source.y;
            int changeX = dest.x - source.x;
            if (changeY == changeX) {
                result = true;
            }
        }
        if (source.y > dest.y && source.x < dest.x) {
            int changeY = source.y - dest.y;
            int changeX = dest.x - source.x;
            if (changeY == changeX) {
                result = true;
            }
        }
        if (source.y < dest.y && source.x > dest.x) {
            int changeY = dest.y - source.y;
            int changeX = source.x - dest.x;
            if (changeY == changeX) {
                result = true;
            }
        }
        if (source.y > dest.y && source.x > dest.x) {
            int changeY = source.y - dest.y;
            int changeX = source.x - dest.x;
            if (changeY == changeX) {
                result = true;
            }
        }
        return result;
    }
}
