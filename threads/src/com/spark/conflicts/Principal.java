package com.spark.conflicts;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        Restroom restroom = new Restroom();
        Thread guest1 = new Thread(new TaskOne(restroom), "Guest 1");
        Thread guest2 = new Thread(new TaskTwo(restroom), "Guest 2");
        Thread cleaner = new Thread(new Cleaning(restroom), "Cleaner");

        cleaner.setDaemon(true);
        guest1.start();
        guest2.start();
        Thread.sleep(10);
        cleaner.start();
    }

}
