package com.spark.servidor;

import java.util.concurrent.BlockingQueue;

public class TaskConsumer implements Runnable {

    private BlockingQueue<String> commandQueue;

    public TaskConsumer(BlockingQueue<String> commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void run() {

        try {
            String command = null;
            while((command = commandQueue.take()) != null) {
                System.out.printf("Consuming %s - Thread %s\n", command, Thread.currentThread().getName());
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
