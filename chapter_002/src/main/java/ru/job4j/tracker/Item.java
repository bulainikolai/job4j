package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * Item
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 03.09.2018
 */
public class Item {
    /**
     * Contains specific number of item
     */
    private String id;

    /**
     * Contains specific name of item
     */
    private String name;

    /**
     * Contains description name of item
     */
    private String description;

    /**
     * Contains creation time of item
     */
    private long create;

    /**
     * Contains array of comments of item
     */
    private ArrayList<String> comments = new ArrayList<>();

    /**
     * Constructor for Item
     * @param name current name of item
     * @param description current description of item
     * @param create time of item's creation
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * Method getName give the name of item
     * @return name of this item
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method getDescription give the description of item
     * @return description of this item
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Method getCreate give the time of item's creation
     * @return time of creation
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * Method getId give the id of this item
     * @return id of item
     */
    public String getId() {
        return this.id;
    }

    /**
     * Method setId set the id of new item
     * @param id id of new item
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method getComments give the array of comments to item
     * @return array of comments
     */
    public ArrayList<String> getComments() {
        return this.comments;
    }

    /**
     * Method setComments add the new comment
     * @param comment some string
     */
    public void setComments(String comment) {
        this.comments.add(comment);
    }
}
