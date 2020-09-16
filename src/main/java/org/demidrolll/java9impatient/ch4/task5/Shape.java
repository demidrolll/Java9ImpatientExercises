package org.demidrolll.java9impatient.ch4.task5;

public abstract class Shape implements Cloneable {

    protected Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        point = new Point(point.getX() + dx, point.getY() + dy);
    }

    public abstract Point getCenter();

    @Override
    public Shape clone() throws CloneNotSupportedException {
        Shape shape = (Shape) super.clone();
        shape.point = this.point.clone();
        return shape;
    }
}
