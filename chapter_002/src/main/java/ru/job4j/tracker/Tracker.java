package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Tracker
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 03.09.2018
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * Contains object of class Random
     */
    private static final Random RN = new Random();

    /**
     * Constructor of object Tracker
     */
    public Tracker() {

    }

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Method findById find current item
     * @param id specific id
     * @return item with current id
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item: this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Method getAll gives all items
     * @return array of all added items
     */
    public List<Item> getAll() {
        return this.items;
    }

    /**
     * Method replace change previous item with new item
     * @param id it is id of deleting item
     * @param item new item instead of previous item
     */
    public void replace(String id, Item item) {
        for (int index = 0; index < this.items.size(); index++) {
            if (!this.items.isEmpty() && this.items.get(index).getId().equals(id)) {
                item.setId(id);
                this.items.set(index, item);
                break;
            }
        }
    }

    /**
     * Method delete is delete of current item from items
     * @param id it is id of deleting item
     */
    public void delete(String id) {
        for (int index = 0; index < this.items.size(); index++) {
            if (!this.items.isEmpty() && this.items.get(index).getId().equals(id)) {
                this.items.remove(index);
                break;
            }
        }
    }

    /**
     * Method findByName find all items by name
     * @param key name of i
     * @return array of items
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item: this.items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }
}
