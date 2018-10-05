package ru.job4j.addTask;

import java.util.Arrays;

/**
 * CoffeMachine
 *
 * @author Nikolai Bulai (turisto777.nb@gmail.com)
 * @version 1
 * @since 05.10.2018
 */
public class CoffeMachine {

    /**
     * Method changes give some count of coins
     * @param value we pay
     * @param price we have to pay
     * @return array of coins
     */
    public int[] changes(int value, int price) {
        int change = value - price;
        int[] money = {1, 2, 5, 10};
        int[] result = new int[0];
        int step = 0;
        boolean stop = false;
        while (!stop) {
            int check = 0;
            for (int index = 0; index < money.length; index++) {
                if (change - money[index] >= 0) {
                    check = money[index];
                } else {
                    break;
                }
            }
            if (check != 0) {
                result = Arrays.copyOf(result, result.length + 1);
                result[step] = check;
                change -= check;
                step++;
            }
            if (change == 0) {
                stop = true;
            }
        }
        return result;
    }
}
