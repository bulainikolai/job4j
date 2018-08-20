package ru.job4j.loop;

/**
 * Board return graphic picture.
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 12.08.2018
 */
public class Board {

    /**
     * Method paint
     * @param width of picture
     * @param height of picture
     * @return String
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String line = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(line);
        }
        return screen.toString();
    }
}
