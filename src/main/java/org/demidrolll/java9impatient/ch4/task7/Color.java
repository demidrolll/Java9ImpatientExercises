package org.demidrolll.java9impatient.ch4.task7;

public enum Color {
    BLACK(0, 0, 0),
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    GREEN(0, 255, 0),
    WHITE(255, 255, 255),
    ;

    private int red;
    private int green;
    private int blue;

    Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    @Override
    public String toString() {
        return
                super.toString() + " " + String.format("#%X%X%X", red, green, blue);
    }

}
