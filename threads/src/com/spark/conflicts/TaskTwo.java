package com.spark.conflicts;

public class TaskTwo implements Runnable {
    private final Restroom restroom;

    public TaskTwo(Restroom restroom) {
        this.restroom = restroom;
    }

    @Override
    public void run() {
        restroom.takeOne();
    }
}