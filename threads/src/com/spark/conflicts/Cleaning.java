package com.spark.conflicts;

public class Cleaning implements Runnable {

    private Restroom restroom;

    public Cleaning(Restroom restroom) {
        this.restroom = restroom;
    }

    @Override
    public void run() {
        while (true) {

            this.restroom.clean();
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
