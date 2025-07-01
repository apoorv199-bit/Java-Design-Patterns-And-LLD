package org.library.Multithreading.threadsSafty;

public class SynchronizationDemo {
    public static void main(String[] args) throws InterruptedException {
        final int NUM_THREADS = 10;
        final int INCREMENTS_PER_THREAD = 1000;

        // Test unsafe counter
        System.out.println("=== Testing Unsafe Counter ===");
        testCounter(new UnsafeCounter(), NUM_THREADS, INCREMENTS_PER_THREAD);

        // Test safe counter with synchronized methods
        System.out.println("\n=== Testing Safe Counter (Synchronized Methods) ===");
        testSafeCounter(new SafeCounter(), NUM_THREADS, INCREMENTS_PER_THREAD);

        // Test safe counter with synchronized blocks
        System.out.println("\n=== Testing Safe Counter (Synchronized Blocks) ===");
        testSafeCounterWithBlocks(new SafeCounterWithBlocks(), NUM_THREADS, INCREMENTS_PER_THREAD);

        // Test atomic counter
        System.out.println("\n=== Testing Atomic Counter ===");
        testAtomicCounter(new AtomicCounter(), NUM_THREADS, INCREMENTS_PER_THREAD);
    }

    private static void testCounter(UnsafeCounter counter, int numThreads, int incrementsPerThread) throws InterruptedException {
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Expected: " + (numThreads * incrementsPerThread));
        System.out.println("Actual: " + counter.getCount());
    }

    private static void testSafeCounter(SafeCounter counter, int numThreads, int incrementsPerThread) throws InterruptedException {
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Expected: " + (numThreads * incrementsPerThread));
        System.out.println("Actual: " + counter.getCount());
    }

    private static void testSafeCounterWithBlocks(SafeCounterWithBlocks counter, int numThreads, int incrementsPerThread) throws InterruptedException {
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Expected: " + (numThreads * incrementsPerThread));
        System.out.println("Actual: " + counter.getCount());
    }

    private static void testAtomicCounter(AtomicCounter counter, int numThreads, int incrementsPerThread) throws InterruptedException {
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Expected: " + (numThreads * incrementsPerThread));
        System.out.println("Actual: " + counter.getCount());
    }
}
