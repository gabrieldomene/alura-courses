package com.spark.lista;

import java.util.List;

public class AddElementTask implements Runnable{

    private Lista lista;
    private int numberThread;

    public AddElementTask(Lista lista, int numberThread) {
        this.lista = lista;
        this.numberThread = numberThread;
    }

    @Override
    public void run() {

        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                lista.add("Thread " + numberThread + " - " + i);
            }
        }
    }
}
