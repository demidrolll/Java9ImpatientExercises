package org.demidrolll.java9impatient.ch4.task2;

public class App {
    public static void main(String[] args) {
        Point a = new Point(10, 20);
        Point b = new Point(10, 20);
        Point c = new Point(10.01, 20);
        Point d = new LabeledPoint("D", 10, 20);
        Point e = new LabeledPoint("d", 10, 20);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        System.out.println(a.equals(b));
        System.out.println(b.equals(a));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
        System.out.println(d.equals(a));
        System.out.println(e.equals(d));
        System.out.println(d.equals(e));
    }
}
