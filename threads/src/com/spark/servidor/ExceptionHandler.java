package com.spark.servidor;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("Exception in thread %s - %s\n", t.getName(), e.getMessage());
    }
}
