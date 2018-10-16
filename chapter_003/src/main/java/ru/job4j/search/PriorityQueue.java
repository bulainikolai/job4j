package ru.job4j.search;

import java.util.LinkedList;

/**
 * PriorityQueue
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 15.10.2018
 */
public class PriorityQueue {
    /**
     * Contains LinkedList of Task's objects
     */
    public LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int correctInd = this.tasks.size();
        if (!this.tasks.isEmpty()) {
            for (int index = 0; index < this.tasks.size(); index++) {
                if (this.tasks.get(index).getPriority() > task.getPriority()) {
                    correctInd = index;
                    break;
                }
            }
        }
        this.tasks.add(correctInd, task);
    }

    /**
     * Method have to return first object from LinkedList
     * @return object Task
     */
    public Task take() {
        return this.tasks.poll();
    }
}
