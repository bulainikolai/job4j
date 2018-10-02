package ru.job4j.addTask;

import java.util.Arrays;

public class CoffeMachine {
    public int[] changes(int value, int price) {
        int change = value - price;
        int[] result = new int[0];
        int index = 0;
        boolean stop = true;
        while (stop) {
            if (change - 10 >= 0) {
                result = Arrays.copyOf(result, result.length + 1);
                result[index] = 10;
                change -= 10;
                index++;
                continue;
            }
            if (change - 5 >= 0) {
                result = Arrays.copyOf(result, result.length + 1);
                result[index] = 5;
                change -= 5;
                index++;
                continue;
            }
            if (change - 2 >= 0) {
                result = Arrays.copyOf(result, result.length + 1);
                result[index] = 2;
                change -= 2;
                index++;
                continue;
            }
            if (change - 1 >= 0) {
                result = Arrays.copyOf(result, result.length + 1);
                result[index] = 1;
                change -= 1;
                index++;
                continue;
            }
            if (change == 0) {
                stop = false;
            }
        }
        return result;
    }
}
