package org.demidrolll.java9impatient.ch3.task9;

public class App {

    public static void main(String[] args) {
        new Thread(new Greeter(10, "one")).start();
        new Thread(new Greeter(5, "two")).start();
    }
}
