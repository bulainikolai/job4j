package ru.job4j.search;

/**
 * Task
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 15.10.2018
 */
public class Task {
    /**
     * Contains description
     */
    private String desc;
    /**
     * Contains level of priority
     */
    private int priority;

    /**
     * Constructor
     * @param desc string
     * @param priority level of priority
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Get description of Task
     * @return desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Get priority of Task
     * @return priority
     */
    public int getPriority() {
        return priority;
    }
}
