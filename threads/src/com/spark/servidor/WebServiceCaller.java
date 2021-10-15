package com.spark.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;

public class WebServiceCaller implements Callable<String> {

    private PrintStream out;

    public WebServiceCaller(PrintStream out) {
        this.out = out;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Executing C2");

        Thread.sleep(5000);
        out.println("C2 executed OK");

        return null;
    }
}
