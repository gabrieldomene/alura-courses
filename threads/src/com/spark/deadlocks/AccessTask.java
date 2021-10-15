package com.spark.deadlocks;

public class AccessTask implements Runnable {

    private ConnectionPool pool;
    private TransactionManager tx;
    public AccessTask(ConnectionPool pool, TransactionManager tx) {
        this.pool = pool;
        this.tx = tx;
    }

    @Override
    public void run() {
        synchronized (pool) {
            System.out.println("Getting pool key");
            pool.getConnection();

            synchronized (tx) {
                System.out.println("Getting tx key");
                tx.begin();
            }
        }
    }
}
