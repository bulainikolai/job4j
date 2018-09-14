package ru.job4j.chess;

import ru.job4j.chess.firuges.*;

public abstract class Board {
    private Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    abstract boolean move(Cell source, Cell dest) throws ImpossibleMoveException,
                OccupiedWayException, FigureNotFoundException;

}
