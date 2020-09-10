package org.demidrolll.java9impatient.ch2;

import java.math.BigDecimal;

public class Task_9 {

    public static void main(String[] args) {
        Car car = new Car(6.5);
        System.out.println(car);
        car.addFuel(5.00);
        System.out.println(car);
        car.drive(0);
        car.drive(1);
        car.drive(10);
        car.drive(50);
        car.drive(15);
        car.drive(2);
        car.drive(1);
        System.out.println(car);
    }
}

class Car {
    /**
     * Distance in km
     */
    private int totalDistance;

    /**
     * Fuel in litres
     */
    private double fuel;

    /**
     * Fuel efficiency by 100 km
     */
    private double efficiency;

    public Car(double efficiency) {
        this.efficiency = efficiency;
    }

    public void drive(int distance) {
        if (distance <= 0 || Double.compare(this.fuel, 0.00) <= 0) {
            return;
        }
        int remainDistance = this.getRemainDistance();
        if (distance > remainDistance) {
            distance = remainDistance;
        }
        this.fuel -= this.getFuelByDistance(distance);
        if (Double.compare(this.fuel, 0.00) <= 0) {
            this.fuel = 0.00;
        }
        this.fuel = BigDecimal.valueOf(this.fuel).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        this.totalDistance += distance;
    }

    public void addFuel(double fuel) {
        this.fuel += fuel;
    }

    public int getRemainDistance() {
        return (int) Math.round(fuel * 100 / efficiency);
    }

    private double getFuelByDistance(int distance) {
        return BigDecimal.valueOf(efficiency * distance / 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return "Car{" +
                "totalDistance=" + totalDistance +
                ", fuel=" + fuel +
                ", efficiency=" + efficiency +
                ", remain distance=" + getRemainDistance() +
                '}';
    }
}
