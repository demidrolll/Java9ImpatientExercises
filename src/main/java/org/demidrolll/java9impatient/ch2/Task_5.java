package org.demidrolll.java9impatient.ch2;

import java.nio.channels.Pipe;

public class Task_5 {
    public static void main(String[] args) {
        ImmutablePoint p = new ImmutablePoint(3, 4).translate(1, 3).scale(0.5);
    }
}

class ImmutablePoint {
    private final double x;
    private final double y;

    public ImmutablePoint() {
        this(0, 0);
    }

    public ImmutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public ImmutablePoint translate(double x, double y) {
        return new ImmutablePoint(this.x + x, this.y + y);
    }

    public ImmutablePoint scale(double scale) {
        return new ImmutablePoint(this.x * scale, this.y * scale);
    }
}
