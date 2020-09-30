package org.demidrolll.java9impatient.ch3.task10;

public class App {

    public static void main(String[] args) {

        Runnable taskOne = new Runnable() {
            @Override
            public void run() {
                System.out.println("one");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable taskTwo = new Runnable() {
            @Override
            public void run() {
                System.out.println("two");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        runTogether(taskOne, taskTwo, taskOne, taskTwo);
        runInOrger(taskOne, taskTwo, taskOne, taskTwo);
    }

    public static void runTogether(Runnable... tasks) {
        System.out.println("run runTogether");
        for (Runnable task : tasks) {
            new Thread(task).start();
        }
        System.out.println("stop runTogether");
    }

    public static void runInOrger(Runnable... tasks) {
        System.out.println("run runInOrger");
        for (Runnable task : tasks) {
            task.run();
        }
        System.out.println("stop runInOrger");
    }
}
