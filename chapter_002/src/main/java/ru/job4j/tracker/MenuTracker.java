package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * MenuTracker
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 07.09.2018
 */
public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор с параметрами.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    private int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Method getRange get List of menu's points
     * @return list of menu's points
     */
    public List<Integer> getRange() {
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < this.getActionsLength(); i++) {
            range.add(i);
        }
        return range;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add program"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program", ui));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Method showInfo help print
     * @param item object, which data will print
     */
    private void showInfo(Item item) {
        ArrayList<String> comments = item.getComments();
        System.out.println("ID: " + item.getId());
        System.out.println("Name: " + item.getName());
        System.out.println("Description: " + item.getDescription());
        for (String comment: comments) {
            System.out.println("Comment: "  + comment);
        }
    }

    /**
     * AddItem - action for adding items
     */
    private class AddItem extends BaseAction {

        /**
         * Constructor
         * @param pointMenu
         * @param message
         */
        public AddItem(int pointMenu, String message) {
            super(pointMenu, message);
        }

        /**
         * Method execute - do main action
         * @param input объект типа Input
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            String comments = input.ask("Введите комментарий к заявке: ");
            Item item = new Item(name, desc, System.currentTimeMillis());
            item.setComments(comments);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    private class ShowItems extends BaseAction {

        /**
         * Constructor
         * @param pointMenu
         * @param message
         */
        public ShowItems(int pointMenu, String message) {
            super(pointMenu, message);
        }

        /**
         * Method execute - do main action
         * @param input объект типа Input
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Отображение списка всех заявок --------------");
            ArrayList<Item> items = tracker.getAll();
            if (items.size() > 0) {
                int number = 1;
                for (Item item: items) {
                    System.out.println(number);
                    showInfo(item);
                    number++;
                }
            } else {
                System.out.println("----------------Заявки отсутствуют--------------");
            }
            System.out.println("------------------------------------------------");
        }
    }

    private static class EditItem extends BaseAction {

        /**
         * Constructor
         * @param pointMenu
         * @param message
         */
        public EditItem(int pointMenu, String message) {
            super(pointMenu, message);
        }

        /**
         * Method execute - do main action
         * @param input объект типа Input
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите id редактируемой заявки: ");
            Item previous = tracker.findById(id);
            if (previous != null) {
                String name = input.ask("Введите новое имя заявки : ");
                String desc = input.ask("Введите новое описание заявки : ");
                String comment = input.ask("Введите новый комментарий к заявке: ");
                Item newItem = new Item(name, desc, System.currentTimeMillis());
                newItem.setComments(comment);
                tracker.replace(previous.getId(), newItem);
                System.out.println("-------------Заявка отредактирована!---------------");
            } else {
                System.out.println("-----------Заявка с данным ID отсутствует!-----------");
            }
        }
    }

    private static class DeleteItem extends BaseAction {

        /**
         * Constructor
         * @param pointMenu
         * @param message
         */
        public DeleteItem(int pointMenu, String message) {
            super(pointMenu, message);
        }

        /**
         * Method execute - do main action
         * @param input объект типа Input
         * @param tracker объект типа Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id удаляемой заявки: ");
            Item deleted = tracker.findById(id);
            if (deleted != null) {
                tracker.delete(deleted.getId());
                System.out.println("--------Заявка удалена!-----------------");
            } else {
                System.out.println("----------Заявка с данным ID отсутствует!----------");
            }
        }
    }
}

class FindItemById extends BaseAction {

    /**
     * Constructor
     * @param pointMenu
     * @param message
     */
    public FindItemById(int pointMenu, String message) {
        super(pointMenu, message);
    }

    /**
     * Method execute - do main action
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = input.ask("Введите id искомой заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            ArrayList<String> comments = item.getComments();
            System.out.println("ID: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Description: " + item.getDescription());
            for (String comment: comments) {
                System.out.println("Comment: "  + comment);
            }
        } else {
            System.out.println("----------------Заявки отсутствуют--------------");
        }
        System.out.println("------------------------------------------------");
    }
}

class FindItemsByName extends BaseAction {

    /**
     * Constructor
     * @param pointMenu
     * @param message
     */
    public FindItemsByName(int pointMenu, String message) {
        super(pointMenu, message);
    }

    /**
     * Method execute - do main action
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск заявки по Имени --------------");
        String name = input.ask("Введите имя искомой заявки: ");
        ArrayList<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            int number = 1;
            for (Item item: items) {
                System.out.println(number);
                ArrayList<String> comments = item.getComments();
                System.out.println("ID: " + item.getId());
                System.out.println("Name: " + item.getName());
                System.out.println("Description: " + item.getDescription());
                for (String comment: comments) {
                    System.out.println("Comment: "  + comment);
                }
                number++;
            }
        } else {
            System.out.println("-------Заявки c таким именем отсутствуют-------");
        }
        System.out.println("------------------------------------------------");
    }
}

class ExitProgram extends BaseAction {

    private final StartUI ui;

    /**
     * Constructor
     * @param pointMenu
     * @param message
     */
    public ExitProgram(int pointMenu, String message, StartUI ui) {
        super(pointMenu, message);
        this.ui = ui;
    }

    /**
     * Method execute - do main action
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Selected point 6. Exit from program.");
        this.ui.stop();
    }
}