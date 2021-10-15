package com.spark.lista;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) throws InterruptedException {

        Lista lista = new Lista();
        for (int i = 0; i < 10; i++) {
            new Thread(new AddElementTask(lista, i)).start();
        }
        new Thread(new PrintTask(lista)).start();

    }
}
