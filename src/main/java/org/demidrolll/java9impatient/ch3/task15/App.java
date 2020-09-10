package org.demidrolll.java9impatient.ch3.task15;

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Mike", 10.00),
                new Employee("Andrew", 5.50),
                new Employee("Scot", 8.81),
                new Employee("Rian", 8.81),
        };

        Comparator<Employee> comparator = Comparator
                .comparing(Employee::getSalary)
                .thenComparing(Employee::getName);
        Arrays.sort(employees, comparator);
        System.out.println(Arrays.toString(employees));

        Arrays.sort(employees, comparator.reversed());
        System.out.println(Arrays.toString(employees));
    }
}
