package ru.job4j.task;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * DepartmentsTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 22.11.2018
 */
public class DepartmentsTest {
    /**
     * Test of sortDepartmentsStraight
     */
    @Test
    public void whenSortArrayThenGetSortedArrayStraight() {
        Departments dep = new Departments();
        String[] departments = {
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };
        String[] result = dep.sortDepartmentsStraight(departments);
        String[] correct = {
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };
        assertThat(result, is(correct));
    }
    /**
     * Test of sortDepartmentsBack
     */
    @Test
    public void whenSortArrayThenGetSortedArrayBack() {
        Departments dep = new Departments();
        String[] departments = {
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        };
        String[] result = dep.sortDepartmentsBack(departments);
        String[] correct = {
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2",
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2"
        };
        assertThat(result, is(correct));
    }
}
