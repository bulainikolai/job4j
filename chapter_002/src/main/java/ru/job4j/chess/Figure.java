package ru.job4j.chess;

import ru.job4j.chess.firuges.*;

public abstract class Figure implements ru.job4j.chess.firuges.Figure {
    private final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    abstract public Cell position();

    abstract public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    abstract public Figure copy(Cell dest);
}
