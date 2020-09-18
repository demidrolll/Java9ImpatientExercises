package org.demidrolll.java9impatient.ch5.task9;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Design a helper method so that one can use a ReentrantLock in a try-with-
 * resources statement. Call lock and return an AutoCloseable whose close method
 * calls unlock and throws no exceptions.
 */

public class App {

    private static class TraceReentrantLock extends ReentrantLock {
        @Override
        public void lock() {
            System.out.println("lock");
            super.lock();
        }

        @Override
        public void unlock() {
            System.out.println("unlock");
            super.unlock();
        }
    }

    public static void main(String[] args) {
        try (AutoCloseable lockRunner = lockHelper()) {
            throw new Exception("test exception");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static AutoCloseable lockHelper() {
        ReentrantLock lock = new TraceReentrantLock();
        lock.lock();
        return lock::unlock;
    }
}
