package org.demidrolll.java9impatient.ch2;

import java.lang.reflect.Array;
import java.util.*;

public class Task_10 {
    public static void main(String[] args) {
        int digit = RandomNumbers.nextInt(2, 10);
        Integer[] digitArray = {1, 2, 3, 4};
        digit = RandomNumbers.randomElement(digitArray);
        List<Integer> digitList = Arrays.asList(digitArray);
        digit = RandomNumbers.randomElement(digitList);
    }
}

class RandomNumbers {
    private static Random generator = new Random();

    public static int nextInt(int low, int high) {
        return low + generator.nextInt(high - low + 1);
    }

    public static int randomElement(Integer[] list) {
        if (list.length == 0) {
            return 0;
        }
        int ind = RandomNumbers.nextInt(0, list.length - 1);
        return list[ind];
    }

    public static int randomElement(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        int ind = RandomNumbers.nextInt(0, list.size() - 1);
        return list.get(ind).intValue();
    }
}
