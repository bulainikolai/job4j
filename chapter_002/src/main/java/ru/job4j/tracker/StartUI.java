package ru.job4j.tracker;

/**
 * StartUI
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 03.09.2018
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Constant of menu for showing all information
     */
    private static final String SHOW = "1";

    /**
     * Constant of menu for editing item
     */
    private static final String EDIT = "2";

    /**
     * Constant of menu for deleting item
     */
    private static final String DELETE = "3";

    /**
     * Constant of menu for searching item by id
     */
    private static final String FINDBYID = "4";

    /**
     * Constant of menu for searching all items by name
     */
    private static final String FINDBYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findItemById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        String comments = this.input.ask("Введите комментарий к заявке: ");
        Item item = new Item(name, desc, System.currentTimeMillis());
        item.setComments(comments);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Method showAllItems show data of all items
     */
    private void showAllItems() {
        System.out.println("------------ Отображение списка всех заявок --------------");
        Item[] items = this.tracker.getAll();
        if (items.length > 0) {
            int number = 1;
            for (Item item: items) {
                System.out.println(number);
                this.showInfo(item);
                number++;
            }
        } else {
            System.out.println("----------------Заявки отсутствуют--------------");
        }
        System.out.println("------------------------------------------------");
    }

    /**
     * Method showAllItems edit current item
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id редактируемой заявки: ");
        Item previous = this.tracker.findById(id);
        if (previous != null) {
            String name = this.input.ask("Введите новое имя заявки : ");
            String desc = this.input.ask("Введите новое описание заявки : ");
            String comment = this.input.ask("Введите новый комментарий к заявке: ");
            Item newItem = new Item(name, desc, System.currentTimeMillis());
            newItem.setComments(comment);
            tracker.replace(previous.getId(), newItem);
            System.out.println("-------------Заявка отредактирована!---------------");
        } else {
            System.out.println("-----------Заявка с данным ID отсутствует!-----------");
        }
    }

    /**
     * Method deleteItem delete current item
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id удаляемой заявки: ");
        Item deleted = this.tracker.findById(id);
        if (deleted != null) {
            tracker.delete(deleted.getId());
            System.out.println("--------Заявка удалена!-----------------");
        } else {
            System.out.println("----------Заявка с данным ID отсутствует!----------");
        }
    }

    /**
     * Method findItemById show information about current item
     */
    private void findItemById() {
        System.out.println("------------ Поиск заявки по ID --------------");
        String id = this.input.ask("Введите id искомой заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            this.showInfo(item);
        } else {
            System.out.println("----------------Заявки отсутствуют--------------");
        }
        System.out.println("------------------------------------------------");
    }

    /**
     * Method findItemById show information items with current name
     */
    private void findItemByName() {
        System.out.println("------------ Поиск заявки по Имени --------------");
        String name = this.input.ask("Введите имя искомой заявки: ");
        Item[] items = this.tracker.findByName(name);
        if (items.length > 0) {
            int number = 1;
            for (Item item: items) {
                System.out.println(number);
                this.showInfo(item);
                number++;
            }
        } else {
            System.out.println("-------Заявки c таким именем отсутствуют-------");
        }
        System.out.println("------------------------------------------------");
    }

    private void showInfo(Item item) {
        String[] comments = item.getComments();
        System.out.println("ID: " + item.getId());
        System.out.println("Name: " + item.getName());
        System.out.println("Description: " + item.getDescription());
        for (String comment: comments) {
            if (comment != null) {
                System.out.println("Comment: "  + comment);
            }
        }
    }

    /**
     * Method findItemById show main menu of available actions
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
