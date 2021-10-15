package com.spark.deadlocks;

public class TransactionManager {

    public void begin() {
        System.out.println("Starting transaction");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
