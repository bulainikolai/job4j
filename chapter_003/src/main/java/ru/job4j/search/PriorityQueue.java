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
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (this.tasks.size() == 0) {
            this.tasks.add(task);
        } else {
            int correctInd = 0;
            for (int index = 0; index < this.tasks.size(); index++) {
                if (this.tasks.get(index).getPriority() < task.getPriority()) {
                    correctInd = index;
                }
            }
            if (this.tasks.size() == 1) {
                this.tasks.add(correctInd, task);
            } else {
                this.tasks.add(correctInd + 1, task);
            }
        }
    }

    /**
     * Method have to return first object from LinkedList
     * @return object Task
     */
    public Task take() {
        return this.tasks.poll();
    }
}
