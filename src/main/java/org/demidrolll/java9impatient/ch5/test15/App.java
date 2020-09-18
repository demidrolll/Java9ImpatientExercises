package org.demidrolll.java9impatient.ch5.test15;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/**
 * Implement and test a log record formatter that produces an HTML file.
 */

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler();
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("test");
        logger.info("drugs");
        logger.info("Java");
        logger.info("C++");
    }
}
