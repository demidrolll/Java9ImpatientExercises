package org.demidrolll.java9impatient.ch10.runnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        Runnable hellos = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Hello " + i);
            }
        };
        Runnable goodbyes = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Goodbye " + i);
            }
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(hellos);
        executor.execute(goodbyes);
    }
}
