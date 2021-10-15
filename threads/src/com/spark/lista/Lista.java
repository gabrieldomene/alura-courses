package com.spark.lista;

public class Lista {

    private String[] elements = new String[100];
    private int index = 0;

    public String getElement(int idx) {
        return this.elements[idx];
    }

    public synchronized void add(String element) {
        this.elements[index] = element;
        this.index++;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (this.index == this.elements.length) {
            System.out.println("list filled, notifying");
            this.notify();
        }
    }

    public int size() {
        return this.elements.length;
    }

}
