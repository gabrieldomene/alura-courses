package com.spark.deadlocks;

public class Principal {

    public static void main(String[] args) {
        TransactionManager tx = new TransactionManager();
        ConnectionPool pool = new ConnectionPool();

        new Thread(new AccessTask(pool, tx)).start();
        new Thread(new AccessTaskProccess(pool, tx)).start();
    }
}
