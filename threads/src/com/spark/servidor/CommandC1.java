package com.spark.servidor;

import java.io.PrintStream;

public class CommandC1 implements Runnable {

    private PrintStream out;

    public CommandC1(PrintStream out) {
        this.out = out;
    }

    @Override
    public void run() {

        this.out.println("Executing C1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.out.println("C1 executed OK");
    }
}
