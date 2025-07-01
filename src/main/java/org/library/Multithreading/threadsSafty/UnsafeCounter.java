package org.library.Multithreading.threadsSafty;

class UnsafeCounter {
    private int count = 0;

    public void increment() {
        count++; // This is not thread-safe!
    }

    public int getCount() {
        return count;
    }
}
