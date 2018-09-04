package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StartUITest
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 03.09.2018
 */
public class StartUITest {

    /**
     * Test of 0. Add new Item
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test1", "desc1", "comment1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test1"));
    }

    /**
     * Test of 2. Edit item.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(
                            new String[]{"2", item.getId(), "test replace", "заменили заявку", "новый коммент", "6"}
                        );
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Test of 1. Show all items
     */
    @Test
    public void whenAddTwoItemsAndFindAllThenTrackerInvolveTwoSameItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1", "desc1", System.currentTimeMillis()));
        tracker.add(new Item("test2", "desc2", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        String[] result = {tracker.getAll()[0].getName(), tracker.getAll()[1].getName()};
        assertThat(result, is(new String[] {"test1", "test2"}));
    }

    /**
     * Test of 3. Delete item
     */
    @Test
    public void whenAddTwoItemsAndDeleteFirstThenTrackerInvolveOnlySecond() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("test1", "desc1", System.currentTimeMillis()));
        tracker.add(new Item("test2", "desc2", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "3", firstItem.getId(), "1", "6"});
        new StartUI(input, tracker).init();
        String[] result = new String[1];
        Item[] allItems = tracker.getAll();
        for (int index = 0; index < allItems.length; index++) {
            result[index] = allItems[index].getName();
        }
        assertThat(result[0], is("test2"));
    }

    /**
     * Test of 4. Find item by Id
     */
    @Test
    public void whenAddOneItemAndFindByIdThenGetSameItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc1", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test1"));
    }

    /**
     * Test of 5. Find items by name
     */
    @Test
    public void whenAddThreeItemsWithTwoEqualsNameAndFindByNameThenGetTwoThoseItems() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("test1", "desc1", System.currentTimeMillis()));
        tracker.add(new Item("test1", "desc2", System.currentTimeMillis()));
        tracker.add(new Item("test2", "desc3", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "5", firstItem.getName(), "6"});
        new StartUI(input, tracker).init();
        String[] result = {tracker.getAll()[0].getDescription(), tracker.getAll()[1].getDescription()};
        assertThat(result, is(new String[] {"desc1", "desc2"}));
    }
}
