package org.demidrolll.java9impatient.ch6.task14;

import java.util.ArrayList;

public class Closeables {
    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
        Exception commonEx = null;
        for (T elem : elems) {
            try {
                elem.close();
            } catch (Throwable ex) {
                if (commonEx == null) {
                    commonEx = new Exception("Closeable list exception");
                }
                commonEx.addSuppressed(ex);
            }
        }
        if (commonEx != null) {
            throw commonEx;
        }
    }
}