package org.demidrolll.java9impatient.ch9.task14;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Implement a serializable class Point with instance variables for x and y.
 * Write a program that serializes an array of Point objects to a file, and
 * another that reads the file.
 */
public class App {

    private static class Point implements Serializable {
        private final double x;
        private final double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 1), new Point(2, 2), new Point(3, 3) };

        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get("points.dat")))) {
            out.writeObject(points);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(points));

        Point[] restoredPoints = null;
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get("points.dat")))) {
            restoredPoints = (Point[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(restoredPoints));
    }
}
