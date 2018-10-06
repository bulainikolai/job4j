package ru.job4j.addtask;

import java.util.ArrayList;
import java.util.List;

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
        int[] money = {10, 5, 2, 1};
        List<Integer> resultList = new ArrayList<>();
        for (int indexM = 0; indexM < money.length; indexM++) {
            int count = change / money[indexM];
            for (int indexR = 0; indexR < count; indexR++) {
                resultList.add(money[indexM]);
            }
            change -= money[indexM] * count;
        }
        int[] resultArray = new int[resultList.size()];
        for (int iter = 0; iter < resultList.size(); iter++) {
            resultArray[iter] = resultList.get(iter);
        }
        return resultArray;
    }
}
