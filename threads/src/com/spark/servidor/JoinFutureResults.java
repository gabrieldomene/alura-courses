package com.spark.servidor;

import java.io.PrintStream;
import java.sql.Time;
import java.util.concurrent.*;

public class JoinFutureResults implements Callable<Void> {


    private final Future<String> futureC2;
    private final PrintStream outClient;
    private final Future<String> futureBanco;

    public JoinFutureResults(Future<String> futureC2, Future<String> futureBanco, PrintStream outClient) {
        this.futureC2 = futureC2;
        this.futureBanco = futureBanco;
        this.outClient = outClient;
    }

    @Override
    public Void call() throws Exception {

        System.out.println("waiting future results");

        try {
            String magicNumber = this.futureC2.get(10, TimeUnit.SECONDS);
            String magicNumber2 = this.futureBanco.get(10, TimeUnit.SECONDS);

            this.outClient.println("C2 " + magicNumber + " - Access " + magicNumber2);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.outClient.print("Timeout fired, cancelled");
            this.futureC2.cancel(true);
            this.futureBanco.cancel(true);
        }
        return null;
    }
}
