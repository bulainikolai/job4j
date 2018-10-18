package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TrackerTest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 03.09.2018
 */
public class TrackerTest {

    /**
     * Test of add
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }

    /**
     * Test of replace
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Test of delete
     */
    @Test
    public void whenDeleteThenReturnWithoutSecondElement() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 1234L);
        Item third = new Item("test3", "testDescription", 12345L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.delete(second.getId());
        String[] result = {"test1", "test3"};
        String[] check = new String[2];
        check[0] = tracker.findById(first.getId()).getName();
        check[1] = tracker.findById(third.getId()).getName();
        assertThat(check, is(result));
    }

    /**
     * Test of getAll
     */
    @Test
    public void whenGetAllThenReturnAllItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        Item second = new Item("test2", "testDescription", 1234L);
        Item third = new Item("test3", "testDescription", 12345L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        String[] result = {"test1", "test2", "test3"};
        String[] check = new String[3];
        ArrayList<Item> allItems = tracker.getAll();
        for (int index = 0; index < allItems.size(); index++) {
            check[index] = allItems.get(index).getName();
        }
        assertThat(check, is(result));
    }

    /**
     * Test of findByName
     */
    @Test
    public void whenFindByNameThenReturnSecondItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1", 123L);
        Item second = new Item("test2", "testDescription2", 1234L);
        Item third = new Item("test3", "testDescription3", 12345L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        ArrayList<Item> resultArray = tracker.findByName("test2");
        assertThat(resultArray.get(0).getDescription(), is("testDescription2"));
    }

    /**
     * Test of findById
     */
    @Test
    public void whenFindByIdThenReturnSecondItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription1", 123L);
        Item second = new Item("test2", "testDescription2", 1234L);
        Item third = new Item("test3", "testDescription3", 12345L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        String result = tracker.findById(second.getId()).getDescription();
        assertThat(result, is("testDescription2"));
    }

}
