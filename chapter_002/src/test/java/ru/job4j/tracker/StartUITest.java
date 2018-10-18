package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
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
     * Contains object of defaulted stream
     */
    private final PrintStream stdout = System.out;

    /**
     * Contains object of buffer
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final String menu = new StringJoiner(System.lineSeparator())
            .add("0. Add program.")
            .add("1. Show all items.")
            .add("2. Edit item.")
            .add("3. Delete item.")
            .add("4. Find item by Id.")
            .add("5. Find items by name.")
            .add("6. Exit Program.")
            .toString();

    /**
     * Method loadOutput change from standard stream to buffer
     */
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Method backOutput change from buffer to standard stream
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Test of 0. Add new Item
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test1", "desc1", "comment1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("test1"));
    }

    /**
     * Test of 2. Edit item.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(
                            new String[]{
                                        "2",
                                        item.getId(),
                                        "test replace",
                                        "заменили заявку",
                                        "новый коммент",
                                        "6"
                            }
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
        String[] result = {tracker.getAll().get(0).getName(), tracker.getAll().get(1).getName()};
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
        List<Item> allItems = tracker.getAll();
        for (int index = 0; index < allItems.size(); index++) {
            result[index] = allItems.get(index).getName();
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
        assertThat(tracker.getAll().get(0).getName(), is("test1"));
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
        String[] result = {tracker.getAll().get(0).getDescription(), tracker.getAll().get(1).getDescription()};
        assertThat(result, is(new String[] {"desc1", "desc2"}));
    }

    /**
     * Test of 1. Show all items Using Buffer
     */
    @Test
    public void whenAddOneItemThenShowAllThenGetItInBuffer() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc1", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringJoiner(
                                System.lineSeparator(), "",
                                System.lineSeparator()
                        )
                                .add(this.menu)
                                .add("------------ Отображение списка всех заявок --------------")
                                .add("1")
                                .add("ID: " + item.getId())
                                .add("Name: " + item.getName())
                                .add("Description: " + item.getDescription())
                                .add("------------------------------------------------")
                                .add(this.menu)
                                .add("Selected point 6. Exit from program.")
                                .toString()
                )
        );
    }

    /**
     * Test of 4. Find item by name Using Buffer
     */
    @Test
    public void whenAddOneItemAndFindItByNameThenGetItInBuffer() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc1", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringJoiner(
                                System.lineSeparator(), "",
                                System.lineSeparator()
                        )
                                .add(this.menu)
                                .add("------------ Поиск заявки по Имени --------------")
                                .add("1")
                                .add("ID: " + item.getId())
                                .add("Name: " + item.getName())
                                .add("Description: " + item.getDescription())
                                .add("------------------------------------------------")
                                .add(this.menu)
                                .add("Selected point 6. Exit from program.")
                                .toString()
                )
        );
    }

    /**
     * Test of 4. Find item by Id Using Buffer
     */
    @Test
    public void whenAddOneItemAndFindItByIdThenGetItInBuffer() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test1", "desc1", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(
                        new StringJoiner(
                                System.lineSeparator(), "",
                                System.lineSeparator()
                        )
                                .add(this.menu)
                                .add("------------ Поиск заявки по ID --------------")
                                .add("ID: " + item.getId())
                                .add("Name: " + item.getName())
                                .add("Description: " + item.getDescription())
                                .add("------------------------------------------------")
                                .add(this.menu)
                                .add("Selected point 6. Exit from program.")
                                .toString()
                )
        );
    }
}
