package org.demidrolll.java9impatient.ch5.task14;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Implement and test a log record filter that filters out log records containing
 * bad words such as sex, drugs, and C++.
 */

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());
    private static final Set<String> excludeLog = new HashSet<>();

    public static void main(String[] args) {
        excludeLog.add("sex");
        excludeLog.add("drugs");
        excludeLog.add("c++");

        logger.setFilter(log -> !excludeLog.contains(log.getMessage().toLowerCase()));

        logger.info("test");
        logger.info("drugs");
        logger.info("Java");
        logger.info("C++");
    }
}
