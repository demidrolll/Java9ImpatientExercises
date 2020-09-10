package org.demidrolll.java9impatient.ch3.task1;

import java.util.*;

public class Task_1 {

    public static void main(String[] args) {
        Employee[] employeeList = {
                new Employee("max", 10),
                new Employee("alex", 30),
                new Employee("andrew", 41),
        };
        System.out.println("avg: " + Task_1.average(employeeList));
        System.out.println("max salary has " + ((Employee) Task_1.largest(employeeList)).getName());
    }

    static double average(Measurable[] objects) {
        return Arrays.stream(objects).mapToDouble(e -> e.getMeasure()).average().orElse(0);
    }

    static Measurable largest(Measurable[] objects) {
        return Arrays.stream(objects).max(Comparator.comparing(Measurable::getMeasure)).orElse(new Employee("unknown", 0.00));
    }

}

interface Measurable {
    double getMeasure();
}

class Employee implements Measurable {

    private double salary;
    private String name;

    public Employee(String name, double salary) {
        this.salary = salary;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getMeasure() {
        return salary;
    }
}
