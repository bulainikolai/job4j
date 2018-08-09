package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Nikolai Bulai (mailto:turisto777.nb@gmail.com)
 * @version 1
 * @since 09.08.2018
 */
public class PointTest {

    /**
     * Test distanceTo.
     */
    @Test
    public void whenFirstDot0And1SecondDot2And5ThenDistance4Point47() {
        Point firstPoint = new Point(0, 1);
        Point secondPoint = new Point(2, 5);
        double distance = firstPoint.distanceTo(secondPoint);
        assertThat(distance, closeTo(4.47, 0.1));
    }
}
