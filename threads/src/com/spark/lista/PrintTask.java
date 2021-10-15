package com.spark.lista;

public class PrintTask implements Runnable {

    private final Lista lista;
    public PrintTask(Lista lista) {
        this.lista = lista;
    }

    @Override
    public void run() {
        synchronized (lista) {
            try {
                System.out.println("Waiting notification");
                lista.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < lista.size(); i++) {
                System.out.printf("%d - %s\n", i, lista.getElement(i));
            }
        }
    }
}
