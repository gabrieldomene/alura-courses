package com.spark.servidor;

import java.io.FileReader;
import java.util.Properties;

public class Principal implements Thread.UncaughtExceptionHandler {

    public static void main(String[] args) {
        Properties properties = new Properties();
        Thread thread = new Thread(new PropertyReader(properties, "autores.txt"));
        thread.setUncaughtExceptionHandler(new Principal());
        thread.start();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.printf("Exception %s captured in thread %s", throwable, thread.getName());
    }
}

