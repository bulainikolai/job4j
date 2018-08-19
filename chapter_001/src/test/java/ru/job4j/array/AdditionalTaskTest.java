package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * AdditionalTaskTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 19.08.2018
 */
public class AdditionalTaskTest {

    /**
     * Test getNewArrayFromTwo
     */
    @Test
    public void whenTwoAssortedArraysThenOneAssorted() {
        AdditionalTask array = new AdditionalTask();
        int[] inputFirst = {2, 10, 30, 32, 40};
        int[] inputSecond = {28, 33, 42, 45, 50};
        int[] result = array.getNewArrayFromTwo(inputFirst, inputSecond);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        int[] expect = {2, 10, 28, 30, 32, 33, 40, 42, 45, 50};
        assertThat(result, is(expect));
    }
}
