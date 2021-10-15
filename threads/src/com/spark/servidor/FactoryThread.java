package com.spark.servidor;

import java.util.concurrent.ThreadFactory;

public class FactoryThread implements ThreadFactory {

    private static int number = 1;
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "Thread Task Server " + number);
        number++;

        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        return thread;
    }
}
