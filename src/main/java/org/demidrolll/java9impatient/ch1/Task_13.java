package org.demidrolll.java9impatient.ch1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task_13 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(49);
        for (int i = 1; i <= 49; i++) {
            list.add(i);
        }

        Random random = new Random();
        ArrayList<Integer> pick = new ArrayList<>(6);
        int ind;
        while (pick.size() < 6) {
            ind = random.nextInt(list.size());
            pick.add(list.get(ind));
            list.remove(ind);
        }
        Collections.sort(pick);

        System.out.println(list.toString());
        System.out.println(pick.toString());
    }
}
