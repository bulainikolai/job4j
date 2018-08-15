package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * ArrayDuplicateTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 15.08.2018
 */
public class ArrayDuplicateTest {

    /**
     * Test remove.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate array = new ArrayDuplicate();
        String[] input = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] resultArray = array.remove(input);
        String[] expect = new String[] {"Привет", "Мир", "Супер"};
        assertThat(resultArray, is(expect));
    }

    /**
     * Test remove.
     */
    @Test
    public void whenMoreRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate array = new ArrayDuplicate();
        String[] input = new String[] {
                "Привет", "Мир", "Привет", "Супер", "Мир", "Супер", "Супер", "Привет", "Дом", "Java"
        };
        String[] resultArray = array.remove(input);
        String[] expect = new String[] {"Привет", "Мир", "Супер", "Дом", "Java"};
        assertThat(resultArray, is(expect));
    }
}
