package org.demidrolll.java9impatient.ch2;

public class Task_6 {
    public static void main(String[] args) {
        Point p = new Point(3, 4);
        p.translate(1, 3);
        p.scale(0.5);
    }
}

class Point {
    private double x;
    private double y;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void scale(double scale) {
        this.x *= scale;
        this.y *= scale;
    }
}
