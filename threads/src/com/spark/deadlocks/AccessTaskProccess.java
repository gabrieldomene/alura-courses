package com.spark.deadlocks;

public class AccessTaskProccess implements Runnable {

    private ConnectionPool pool;
    private TransactionManager tx;

    public AccessTaskProccess(ConnectionPool pool, TransactionManager tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
        synchronized (tx) {
            System.out.println("Getting tx key");

            tx.begin();

            synchronized (pool) {
                System.out.println("Getting pool key");
                pool.getConnection();
            }
        }
    }
}
