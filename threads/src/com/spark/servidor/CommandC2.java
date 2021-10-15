package com.spark.servidor;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.Callable;

public class CommandC2 implements Callable<String> {

    private PrintStream out;

    public CommandC2(PrintStream out) {
        this.out = out;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Running command C2");

        out.println("processando c2 simple");
        Thread.sleep(10000);

        int number = new Random().nextInt(100) + 1;
        out.println("server finished c2 ok");
        return Integer.toString(number);
    }
}
