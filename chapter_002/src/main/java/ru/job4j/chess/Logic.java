package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Optional;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Метод перезаписывает элемент массива фигур новым объектом фигуры после хода
     * @param source начальное положение двигающейся фигуры
     * @param dest конечное положение двигающейся фигуры
     * @return истину, если в массиве с положениями фигур перезаписан объект передвинутой фигуры
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException,
            OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        try {
            int index = this.findBy(source);
            Cell[] steps = this.figures[index].way(source, dest);
            this.allowableTarget(this.figures, steps);
            rst = true;
            this.figures[index] = this.figures[index].copy(dest);
        } catch (FigureNotFoundException fnf) {
            System.out.println("Figure not found");
        } catch (OccupiedWayException owe) {
            System.out.println("Way is occupied");
        } catch (ImpossibleMoveException ime) {
            System.out.println("Can't move by this way");
        }
        return rst;
    }

    /**
     * Стирание массива со старыми позициями фигур и обнуление счетчика
     */
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    /**
     * Метод вернет индекс массива figures, в котором лежит искомая фигура
     * @param cell параметр фигуры типа Cell.A1
     * @return индекс в массиве для искомой фигуры
     */
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        if (rst == -1) {
            throw new FigureNotFoundException("Figure not found");
        }
        return rst;
    }

    /**
     * Проверка на допустимость хода, свободны ли клетки на пути хода
     * @param figures массив фигур с их текущим положением на доске
     * @param steps Массив шагов, которые предполагается совершить
     * @return истина, если шаги, которыерые нужно сделать не заняты
     */
    private boolean allowableTarget(Figure[] figures, Cell[] steps) {
        boolean result = true;
        for (Cell step: steps) {
            for (Figure figure : figures) {
                if (figure.position().equals(step)) {
                    result = false;
                }
            }
        }
        if (!result) {
            throw new OccupiedWayException("Way is occupied");
        }
        return result;
    }
}
