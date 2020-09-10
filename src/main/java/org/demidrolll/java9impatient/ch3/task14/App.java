package org.demidrolll.java9impatient.ch3.task14;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Runnable> list = new ArrayList<>();
        list.add(new Runnable() {
            @Override
            public void run() {
                System.out.println("run1");
            }
        });

        list.add(new Runnable() {
            @Override
            public void run() {
                System.out.println("run2");
            }
        });

        method(list.toArray(new Runnable[list.size()])).run();
    }

    public static Runnable method(Runnable[] list) {
        return () -> {
            for (Runnable item : list) {
                item.run();
            }
        };
    }
}
