package com.mjc.stage2;

public class ThreadSafeSingleton {

    private static volatile ThreadSafeSingleton INSTANCE;

    public static synchronized ThreadSafeSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafeSingleton();
        }
        return INSTANCE;
    }
}
