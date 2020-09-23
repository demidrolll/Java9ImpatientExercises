package org.demidrolll.java9impatient.ch6.task14;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Implement an improved version of the closeAll method in Section 6.3,
 * “Type Bounds” (page 210). Close all elements even if some of them throw
 * an exception. In that case, throw an exception afterwards. If two or more
 * calls throw an exception, chain them together.
 */

public class App {
    public static void main(String[] args) {
        ArrayList<PrintStream> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        try {
            Closeables.closeAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
