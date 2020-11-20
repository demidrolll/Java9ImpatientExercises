package org.demidrolll.java9impatient.ch9.task6;

import java.io.IOException;

/**
 * The BMP file format for uncompressed image files is well documented
 * and simple. Using random access, write a program that reflects each row
 * of pixels in place, without writing a new file.
 */
public class App {
    public static void main(String[] args) {
        try (BitmapReader reader = BitmapReader.open("image.bmp")) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
