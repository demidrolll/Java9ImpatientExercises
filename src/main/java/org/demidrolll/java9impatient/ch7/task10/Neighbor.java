package org.demidrolll.java9impatient.ch7.task10;

import java.util.Comparator;

public class Neighbor {
    private City city;
    private int distance;

    public Neighbor(City city, int distance) {
        this.city = city;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public City getCity() {
        return city;
    }
}
