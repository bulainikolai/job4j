package ru.job4j.chess.firuges;


public interface Figure {
    /**
     *
     * @return
     */
    Cell position();

    /**
     *
     * @param source
     * @param dest
     * @return
     */
    Cell[] way(Cell source, Cell dest);

    /**
     *
     * @return
     */
    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    /**
     *
     * @param dest
     * @return
     */
    Figure copy(Cell dest);

}
