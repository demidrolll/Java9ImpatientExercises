package org.demidrolll.java9impatient.ch4.task5;

/**
 * Define clone methods for the classes of the preceding exercise.
 */

public class App {

    public static void main(String[] args) throws CloneNotSupportedException {
        Point a = new Point(10, 20);
        Point b = a.clone();
        Circle c = new Circle(new Point(1, 2), 50);
        Shape d = new Rectangle(new Point(50, 50), 100, 200);
        System.out.println(b);
        Shape p = c.clone();
        Circle e = c.clone();
    }

}
