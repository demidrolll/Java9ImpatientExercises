package org.demidrolll.java9impatient.ch3.task7;

public class App {
    public static void main(String[] args) {
        DigitSequence sequence = new DigitSequence(123456);

        while (sequence.hasNext()) {
            System.out.println(sequence.next());
        }
    }
}
