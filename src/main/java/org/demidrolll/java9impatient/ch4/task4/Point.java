package org.demidrolll.java9impatient.ch4.task4;

public class Point {
    private double x;
    private double y;

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

    @Override
    public String toString() {
        return "Point (" + x + ", " + y + ") with hashCode " + hashCode();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }
        Point other = (Point) otherObject;
        return
                Double.compare(this.x, other.x) == 0
                && Double.compare(this.y, other.y) == 0
                ;
    }

    @Override
    public int hashCode() {
        return
                Double.hashCode(x)
                + Double.hashCode(y)
                ;
    }
}
