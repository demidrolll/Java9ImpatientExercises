package org.demidrolll.java9impatient.ch4.task4;

public class Line extends Shape {

    private Point to;

    public Line(Point from, Point to) {
        super(from);
        this.to = to;
    }

    @Override
    public Point getCenter() {
        return new Point((to.getX() + point.getX()) / 2, (to.getY() + point.getY()) / 2);
    }
}
