package org.library.Multithreading.basicThreads;

public class BasicThreadsDemo {
    public static void main(String[] args) {
        System.out.println("=== Method 1: Extending Thread ===");
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");

        thread1.start();
        thread2.start();

        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Method 2: Implementing Runnable ===");
        Thread thread3 = new Thread(new MyRunnable("Runnable-1"));
        Thread thread4 = new Thread(new MyRunnable("Runnable-2"));

        thread3.start();
        thread4.start();

        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Using Lambda Expressions ===");
        Thread thread5 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Lambda Thread - Count: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread5.start();
        try {
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads completed!");
    }
}
