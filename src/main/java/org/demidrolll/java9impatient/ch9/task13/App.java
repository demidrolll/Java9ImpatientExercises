package org.demidrolll.java9impatient.ch9.task13;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.MessageFormat;

/**
 * Implement a method that can produce a clone of any serializable object
 * by serializing it into a byte array and deserializing it.
 */
public class App {

    private static class ToCloneObject implements Serializable {
        private String name;
        private Integer age;
        private double salary;

        public ToCloneObject(String name, Integer age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return MessageFormat.format("name: {0}\nage: {1, number}\nsalary: {2, number}\n", name, age, salary);
        }
    }

    public static void main(String[] args) {
        ToCloneObject original = new ToCloneObject("Jon", 50, 122.00);
        ToCloneObject copy = (ToCloneObject) cloneViaSerializing(original);

        System.out.println(original);
        System.out.println(copy);
    }

    private static Object cloneViaSerializing(Object obj) {
        try {

            byte[] data;
            Object result;

            try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                 ObjectOutputStream stream = new ObjectOutputStream(out)) {
                stream.writeObject(obj);
                data = out.toByteArray();
            }

            try (ByteArrayInputStream in = new ByteArrayInputStream(data);
                 ObjectInputStream stream = new ObjectInputStream(in)) {
                result = stream.readObject();
            }

            return result;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
