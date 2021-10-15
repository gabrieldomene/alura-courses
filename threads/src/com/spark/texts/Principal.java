package com.spark.texts;

public class Principal {

    public static void main(String[] args) {
        String nome = "Jon";

        Thread signs1 = new Thread(new BuscaTextual("assinaturas1.txt", nome));
        signs1.start();
        Thread signs2 = new Thread(new BuscaTextual("assinaturas2.txt", nome));
        signs2.start();
        Thread authors = new Thread(new BuscaTextual("autores.txt", nome));
        authors.start();

        new Thread(() -> {
            for (var i = 0; i < 1000; i++){
                System.out.printf("%s - %d\n", Thread.currentThread().getId(), i);
            }
        }).start();


        new Thread(() -> {
            for (var i = 0; i < 1000; i++){
                System.out.printf("%s - %d\n", Thread.currentThread().getId(), i);
            }
        }).start();
    }
}
