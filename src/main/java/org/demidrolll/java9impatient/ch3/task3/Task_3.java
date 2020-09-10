package org.demidrolll.java9impatient.ch3.task3;

public class Task_3 {
    public static void main(String[] args) {
        IntSequence seq = IntSequence.constant(1);
        while (seq.hasNext()) {
            System.out.println(seq.next());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

interface IntSequence {
    default boolean hasNext() {
        return true;
    }

    int next();

    static IntSequence of(int ... args) {
        return new IntSequence() {

            private int[] list = args;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return args.length > 0 && index < args.length;
            }

            @Override
            public int next() {
                return list[index++];
            }
        };
    };

    static IntSequence constant(int value) {
        return () -> value;
    }
}
