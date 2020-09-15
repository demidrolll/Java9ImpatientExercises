package org.demidrolll.java9impatient.ch4.task2;

import java.util.Objects;

public class LabeledPoint extends Point {

    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "\"" + label + "\" " + super.toString();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) {
            return false;
        }
        LabeledPoint other = (LabeledPoint) otherObject;
        return
                (this.label != null && this.label.equalsIgnoreCase(other.label))
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label);
    }
}
