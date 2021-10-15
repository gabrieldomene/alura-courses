package com.spark.conflicts;

public class TaskOne implements Runnable {
    private final Restroom restroom;

    public TaskOne(Restroom restroom) {
        this.restroom = restroom;
    }

    @Override
    public void run() {
        restroom.takeTwo();
    }
}
